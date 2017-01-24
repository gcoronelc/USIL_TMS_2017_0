/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Alumno
 */
public class Promedio {
    
    public double obtenerPromedioPractica(int pc1,int pc2,int pc3,int pc4){
        double pp;
        pp=((pc1+pc2+pc3+pc4)/4);
        return pp;
    }
    
    public double obtenerPromedioFinal(double ep,double ef, double pp){
        
        double pf;
        
        pf= (pp*0.30)+(ep*0.30)+(ef*0.40);
        return pf;
    }

}
