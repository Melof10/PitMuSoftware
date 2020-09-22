package clases;

import metodos.Guardar;

public class RoundRobin {                            
    
    private Guardar miGuardar = new Guardar();
    private Partidos miPartidos = new Partidos();
    
    public RoundRobin() {
                
    }

    public void combinarEquiposParFormatoIda(Equipo [] equipos) {
        
        Equipo buffer = equipos[equipos.length - 1];
        
        for (int i = equipos.length - 1; i > 1; i--) {
            equipos[i] = equipos[i - 1];
        }
        
        equipos[1] = buffer;
        
    }

    public void combinarEquiposParFormatoIdaYVuelta(Equipo [] equipos) {
        
        Equipo buffer = equipos[equipos.length - 1];
        
        for (int i = equipos.length - 1; i > 1; i--) {
            equipos[i] = equipos[i - 1];
        }
        
        equipos[1] = buffer;                             

    }

    public void mostrarFormatoIda(int idTorneo, int numeroDeFecha, Equipo [] equipos) {                
        
        for (int i = 0, j = equipos.length - 1; i < j; i++, j--) {            
            miGuardar.guardarPartidosLiga(idTorneo, numeroDeFecha, equipos[i], equipos[j]);
        }        
        
    }
    
    public void mostrarFormatoIdaYVuelta(int idTorneo, int numeroDeFecha, Equipo [] equipos) {
        
        for (int i =  equipos.length - 1, j = 0; i > j; i--, j++) {         
            miGuardar.guardarPartidosLiga(idTorneo, numeroDeFecha, equipos[i], equipos[j]);
        }        
        
    }
    
    
    public void combinarEquiposImpar() {

    }
    
}


