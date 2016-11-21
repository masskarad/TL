package annotation;

public @interface TLTest
{
	public enum STATUS {NOTEST, TOTEST, TESTED};

	public abstract STATUS status(); 
}
