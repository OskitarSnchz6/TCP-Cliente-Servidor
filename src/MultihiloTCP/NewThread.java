package MultihiloTCP;

public class NewThread implements Runnable{
	String nombreHilo;



	public void run() {

		try {
            for (int i=0; i<10; i++){
                Thread.sleep(5000);
                System.out.println(i+" "+nombreHilo);
            }
        }catch (InterruptedException exc){
            System.out.println(nombreHilo + "Interrumpido.");
        }
        System.out.println("FIN! " + nombreHilo);
	}
}