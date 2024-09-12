package br.com.edu.ufabc.isilanguage.datastructure;

public abstract class IsiSymbol {
    
    protected String name;
    protected boolean isUsed = false;
	protected boolean isInitialized = false;

    public abstract String generateJavaCode();
    public abstract String generatePythonCode();

    public IsiSymbol(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public boolean isUsed() {
		return isUsed;
	}

	public void setUsed() {
		isUsed = true;
	}
	public boolean isInitialized() {
		return isInitialized;
	}

	public void setInitialized() {
		isInitialized = true;
	}

    @Override
    public String toString() {
        return "IsiVariable [name=" + getName() + ", used=" + isUsed() + ", initialized=" + isInitialized() + "]";
    }

	public abstract int getType();

}
