package tp4.exo1;

public class EntierOrdonnable implements Ordonnable
{
	private int entier;

	EntierOrdonnable(int entier)
	{
		this.entier=entier;
	}

	public boolean estPlusGrand(Object o)
	{
		return entier> ((EntierOrdonnable)o).entier;
	}

	public String toString()
	{
		return String.valueOf(entier);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntierOrdonnable other = (EntierOrdonnable) obj;
		if (entier != other.entier)
			return false;
		return true;
	}

}
