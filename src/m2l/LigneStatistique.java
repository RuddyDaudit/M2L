/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2l;

/**
 *
 * @author Mathieu
 */
public class LigneStatistique
{
    private Object valeur1 = null;
    private Object valeur2 = null;
    private Object valeur3 = null;
    
    public LigneStatistique(Object v1, Object v2)
    {
        valeur1 = v1;
        valeur2 = v2;
    }
    
    public LigneStatistique(Object v1, Object v2, Object v3)
    {
        valeur1 = v1;
        valeur2 = v2;
        valeur3 = v3;
    }

    public Object getValeur1()
    {
        return valeur1;
    }
    
    public Object getValeur2()
    {
        return valeur2;
    }
    
    public Object getValeur3()
    {
        return valeur3;
    }
    
    public String toString()
    {
        String desc = valeur1.toString() + " - " + valeur2.toString();
        if (valeur3 != null)
            desc = desc + " - " + valeur3.toString();
        return desc;
    }
    

}
