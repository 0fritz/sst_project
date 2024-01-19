package ro.uvt.dp.Accounts;

public interface Operations {
	public double getTotalAmount();

	public double getInterest();

	public void depose(double amount) throws Exception;

	public void retrieve(double amount) throws Exception;
}
