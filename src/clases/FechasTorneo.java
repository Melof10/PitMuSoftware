package clases;

public class FechasTorneo {
    
    private int idTorneo;
    private int fechaTorneo;
    
    public FechasTorneo(){
        
    }  
    
    @Override
    public String toString(){
        return "FECHA "+getFechaTorneo();
    }

    public int getFechaTorneo() {
        return fechaTorneo;
    }

    public void setFechaTorneo(int fechaTorneo) {
        this.fechaTorneo = fechaTorneo;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }
    
}
