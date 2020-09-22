package formularios.Altas;

import javax.swing.JProgressBar;

public class cargar_1 extends Thread {

    JProgressBar progreso;

    public cargar_1(JProgressBar progreso) {
        super();
        this.progreso = progreso;
    }

    @Override
    public void run() {

        for (int a = 1; a <= 100; a++) {
            progreso.setValue(a);
            pausa(10);
        }

    }

    public void pausa(int mlseg) {
        try {
            Thread.sleep(mlseg);
        } catch (Exception e) {
        }
    }

}
