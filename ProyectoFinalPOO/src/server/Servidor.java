package server;

import java.io.*;
import java.net.*;

public class Servidor extends Thread {
    private ServerSocket serverSocket;
    private boolean enEjecucion = true;

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(5050);
            System.out.println("Servidor de respaldo iniciado en puerto 5000");

            while (enEjecucion) {
                try {
                    Socket cliente = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                    String mensaje = in.readLine();

                    if ("RESPALDAR".equalsIgnoreCase(mensaje)) {
                        realizarRespaldo();
                    }

                    cliente.close();
                } catch (IOException e) {
                    if (enEjecucion) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al iniciar el servidor de respaldo.");
            e.printStackTrace();
        }
    }

    public void detenerServidor() {
        enEjecucion = false;
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                System.out.println("Servidor de respaldo detenido.");
            }
        } catch (IOException e) {
            System.out.println("Error al detener el servidor.");
            e.printStackTrace();
        }
    }

    private void realizarRespaldo() {
        String[] archivos = { "empresas.dat", "candidatos.dat", "vacantes.dat", "postulaciones.dat" };
        for (String archivo : archivos) {
            File original = new File(archivo);
            File respaldo = new File(archivo.replace(".dat", "_respaldo.dat"));
            try (
                FileInputStream in = new FileInputStream(original);
                FileOutputStream out = new FileOutputStream(respaldo)
            ) {
                byte[] buffer = new byte[1024];
                int bytesLeidos;
                while ((bytesLeidos = in.read(buffer)) > 0) {
                    out.write(buffer, 0, bytesLeidos);
                }
            } catch (IOException e) {
                System.out.println("Error al respaldar " + archivo);
                e.printStackTrace();
            }
        }
    }
}
