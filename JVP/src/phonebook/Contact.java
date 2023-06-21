/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonebook;

public class Contact 
{

    String Name, Ct_No;

    public void setName(String name) 
    {
        this.Name = name;
    }

    public void setNo(String cno) 
    {
        this.Ct_No = cno;
    }

    public String getName() 
    {
        return Name;
    }

    public String getNo() 
    {
        return Ct_No;
    }

    public String toString() 
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append(Name);
        return buffer.toString();
    }
}  
