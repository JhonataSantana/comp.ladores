package br.com.edu.ufabc.isilanguage.datastructure;

public class IsiVariable extends IsiSymbol{
    
    public static final int NUMBER = 0;
    public static final int TEXT = 1;
    public static final int CHAR = 2;
	public static final int BOOLEAN = 3;

    private int type;
    private String value;

    public IsiVariable(String name, int type, String value) {
        super(name);
        //setType(type);
		setValue(value);
		this.type = type;
		this.isUsed();
    }

     public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "IsiVariable[" + "name=" + getName() + ", type=" + getType() + ", value=" + getValue() + "]";
    }

    public String generateJavaCode(){
        String str;
        if (type == NUMBER) {
            str = "double ";
        } 
        else if(type == TEXT){
			str = "String ";
		}
		else if(type == CHAR){
			str = "char ";
		}
		else {
			str = "boolean ";
		}
		return str + " " + super.name + ";";
    }

    public String generatePythonCode(){
        //return super.name+"\n";
        return "";
    }

}
