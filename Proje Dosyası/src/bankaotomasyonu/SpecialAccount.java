package bankaotomasyonu;

import java.time.LocalDate;
import java.time.Period;

public class SpecialAccount extends Account
{
	
	public  SpecialAccount(int id, int balance) 
	{
		
		super.setAccountId(id);
		super.setBakiye(balance);
		super.type = AccountType.SPECIAL;
	}

	@Override
	public void accountRules() 
	{
		
		System.out.println("Yıllık %12 faiz verir ve en az hesap açılışındaki kadar bakiye olmak zorundadır.");
	}

	@Override
	public float benefit() 
	{
		
		  int year =Period.between(super.opening_account_date, LocalDate.now()).getYears();
		  int month =Period.between(super.opening_account_date, LocalDate.now()).getMonths();
		  int day =Period.between(super.opening_account_date, LocalDate.now()).getDays();
		  
		  int total_days = year*365 + 30*month + day;
		  
		  float faiz_miktari =  ( (getBakiye() *((float)12/365) / 100 ) * total_days);
		  
		  return faiz_miktari;
	} 
}
