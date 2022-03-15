// Base class for banks
class Bank {
    double personalLoan;
    double homeLoan;
    double educationalLoan;
    double goldLoan;

    //Parameterized Constructor
    public Bank(double personalLoan, double homeLoan, double educationalLoan, double goldLoan) {
        this.personalLoan = personalLoan;
        this.homeLoan = homeLoan;
        this.educationalLoan = educationalLoan;
        this.goldLoan = goldLoan;
    }

    /**
     *
     * @param obj Bank class object
     * @param loanType type of loan
     * @param principal principal amount
     * @param years loan tenure
     * @return return interest amount
     */
    public double interestAmount(Bank obj, int loanType, long principal, int years){
        double interest = 0;
        switch (loanType){
            case 1:
                interest =  obj.personalLoan;
                break;
            case 2:
                interest =  obj.homeLoan;
                break;
            case 3:
                interest = obj.educationalLoan;
                break;
            case 4:
                principal = principal * 3250;
                interest = obj.goldLoan;
                break;
        }
        return principal * interest * years / 100;
    }
}
