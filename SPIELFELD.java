public class SPIELFELD extends SPIEL {

    private SCHIFF[]spielfeld1;
    private SCHIFF[]spielfeld2;

    public SPIELFELD(){
        super();
        spielfeld1 = new SCHIFF[100];
        int x = 0;
        for(int z1=0; z1<10; z1++){
            for(int z2=0; z2<10; z2++){
                spielfeld1[x] = new SCHIFF(30+z2*36+12+10, 125+z1*36+12);
            }
        }
        
        
        
        spielfeld2 = new SCHIFF[100];
        x=0;
        for(int z1=0; z1<10; z1++){
            for(int z2=0; z2<10; z2++){
                spielfeld2[x] = new SCHIFF(30+360+30+z2*36+12+20, 125+z1*36+12);
            }
        }
    }
    
    @Override
    public void tick() {}
    
    @Override
    public void tasteReagieren( int code ) {
        
    }
}
