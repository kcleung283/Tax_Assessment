package Mathprovider;

public class Main {

	  /* Below calculates an individual's MPF according to his/her income */
	  static int calculateMPF(int income, int mpf) {
		  if ((income/12)<7100) {
			  return mpf = 0;
		  } else {
			  int temp = (int) ((int)income * 0.05);
			  if (temp > 18000) {
				  return mpf = 18000;
			  } else {
				  return mpf =temp;
			  }
		  }
	  }
	  
	  /* Below calculates Net Chargeable Income of an individual/ married couple */
	  static int calculateNet(int income, int mpf, int allowance, int Net) {
		  return Net = income - mpf - allowance;
	  }
	  
	  /* Below calculates Tax Payable of an individual/ married couple
	   * according to different Tax Rates */
	  
	  public int calculateTax(int net, int tax, boolean joint) {

		  double first = 50000 * 0.02;		//On the 1st 50,000 at 2%
		  double second = 50000 * 0.06;		//On the 2nd 50,000 at 6%
		  double third = 50000 * 0.1;		//On the 3rd 50,000 at 10%
		  double forth = 50000 * 0.14;		//On the 4th 50,000 at 14%
		  int standard = 0, progressive = 0;
		  
		  /* Below calculates the Tax Payable while using Standard Tax Rate */
		  
		  if (joint == true) {
			   standard = (int) ((net+132000*2)*0.15);
		  } else {
			  standard = (int) ((net+132000)*0.15);
		  }
		  
		  /* Below calculates the Tax Payable while using Progressive Tax Rate */
		  
		  if (net < 50) {
			  progressive = 0;
		  } else if (net <= 50000){
			  progressive = (int) (net * 0.02);
		  } else if ((net>50000) && (net<=100000)){
			  progressive = (int) (first + (net-50000)*0.06);
		  } else if ((net>100000) && (net<=150000)) {
			  progressive = (int) (first + second + (net-50000*2)*0.1);
		  } else if ((net>150000) && (net<=200000)) {
			  progressive = (int) (first + second + third + (net-50000*3)*0.14);
		  } else if (net>200000) {
				  
			  /* If Net Chargeable Income is over 200,000, the remainder will be multiplied by 17% */
				  
			  progressive = (int) (first + second + third + forth + (net-50000*4)*0.17);
		  }
		  
		  /* Below compares if Tax Payable under Standard Tax Rate or Progressive Tax rate is lower,
		   * then choose the better option*/
		  
		  if (standard<progressive) {
			  tax = standard;
		  } else {
			  tax = progressive;
		  }
	   	
		  return tax;
		   
	  }
	  
	  /* Below compares if Tax Payable under Separate Taxation or Joint Assessment is lower,
	   * then recommends the better choice for the user */
	  
	  static int Choice(int separate, int joint) {
		  	int pay = 0;
		  	System.out.println();
		    if (separate < joint) {
		        System.out.println("Therefore, Separate Taxation is preferred!"); 
		        pay = separate;
		      } else if (separate > joint) {
		        System.out.println("Therefore, Joint Assessment is preferred!"); 
		        pay = joint;
		      } else if (separate == joint) {
			    System.out.println("Therefore, Total Tax Payable under Two Systems are the Same!");
		    	pay = separate;  
		      }
		    return pay;
	  }

	  /* Main Program */
	  public int main(int self, int spouse) {
		  int SelfMPF, SpouseMPF, allowance, SelfNet, SpouseNet, SelfTax, SpouseTax, TotalNet, SeparateTaxation, JointAssessment, TaxPayable;
		  boolean joint = false;
		  SelfMPF = 0;
		  SpouseMPF = 0;
		  allowance = 132000;	//Allowance is set to 132,000
		  SelfNet = 0;
		  SpouseNet = 0;
		  SelfTax = 0;
		  SpouseTax = 0;
		  JointAssessment = 0;
		  TaxPayable = 0;
		  
		  System.out.println("Your Total Income: HK$ " + self);		//Displays the user's income
		  System.out.println("Your Spouse's Total Income: HK$ " + spouse);		//Displays their spouse's income
		  SelfMPF = calculateMPF(self, SelfMPF);		//Calculates the user's MPF
		  SpouseMPF = calculateMPF(spouse, SpouseMPF);		//Calculates their spouse's MPF
		  System.out.println();
		  System.out.println("Your MPF Mandatory Contribution: HK$ " + SelfMPF);		//Displays the user's MPF
		  System.out.println("Your Spouse's MPF Mandatory Contribution: HK$ " + SpouseMPF);		//Displays their spouse's MPF

		  SelfNet = calculateNet(self, SelfMPF, allowance, SelfNet);		//Calculates the user's Net Chargeable Income
		  SpouseNet = calculateNet(spouse, SpouseMPF, allowance, SpouseNet);		//Calculates their spouse's Net Chargeable Income
		 
		  SelfTax = calculateTax(SelfNet, SelfTax, joint);		//Calculates the user's Tax Payable
		  SpouseTax = calculateTax(SpouseNet, SpouseTax, joint);		//Calculates their spouse's Tax Payable
		  
		  System.out.println();
		  System.out.println("Your Total Tax Payable: HK$ " + SelfTax);		//Displays the user's Tax Payable
		  System.out.println("Your Spouse's Total Tax Payable: HK$ " + SpouseTax);		//Displays their spouse's Tax Payable
		  SeparateTaxation = SelfTax + SpouseTax;		//Calculate Total Tax Payable under Separate Taxation
		  TotalNet = SelfNet + SpouseNet;		//Calculate Total Net Chargeable Income
		  
		  /* Assign the boolean joint to true if the Tax calculation is under Joint Assessment */
		  joint = true;
		  JointAssessment = calculateTax(TotalNet, JointAssessment, joint);	//Calculate Total Tax Payable under Joint Assessment
		  joint = false;
		  
		  /* Display Total Tax Payable under two systems */
		  System.out.println("So, Total Tax Payable by You and Your Spouse under Separate Taxation: HK$ " + SeparateTaxation);
		  System.out.println();
		  System.out.println("Total Tax Payable by You and Your Spouse under Joint Assessment: HK$ " + JointAssessment);
		  TaxPayable = Choice(SeparateTaxation, JointAssessment);	//Recommends the better option for the user
		  return TaxPayable;
		 
	  }
	  
	}
