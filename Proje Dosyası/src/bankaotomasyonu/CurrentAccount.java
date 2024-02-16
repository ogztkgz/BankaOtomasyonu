package bankaotomasyonu;

import java.time.LocalDate;
import java.time.Period;

public class CurrentAccount extends Account
{

	public  CurrentAccount(int id) {
		
		super.setAccountId(id);
		super.type = AccountType.CURRENT;
	}

	
	@Override
	public void accountRules() 
	{
		
		System.out.println("Hesap faizsiz ve para olma zorunluluğu yoktur.");
	}


	@Override
	public float benefit() 
	{
		
		 /*Hesap faizsizdir*/
		return 0.0F;
	}

}
