package bankaotomasyonu;

import java.time.LocalDate;
import java.time.Period;

public class ShortTermAccount extends Account
{
	
	public ShortTermAccount(int Id, int balance) 
	{
		
		super.setAccountId(Id);
		super.setBakiye(balance);
		super.type =AccountType.SHORTTERM;
		
	}
	@Override
	public void accountRules() 
	{
		
		System.out.println("Yıllık %17 faiz verir ve en az 1000 tl bakiye olmak zorundadır.");
	}
	
	@Override
	public float benefit() 
	{
		/*yıllık %17 faiz verir*/
		  int year =Period.between(super.opening_account_date, LocalDate.now()).getYears();
		  int month =Period.between(super.opening_account_date, LocalDate.now()).getMonths();
		  int day =Period.between(super.opening_account_date, LocalDate.now()).getDays();
		  
		  int total_days = year*365 + 30*month +day;
		  
		  float faiz_miktari =  ( (super.getBakiye() *((float)17/365) / 100 ) * total_days);
		  return faiz_miktari;
		
	}
}
