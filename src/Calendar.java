public class Calendar{
    private int day;
    private int month;
    private int year;

    public Calendar(int year, int month, int day){
        if(year > 0){
            this.year = year;
        }
        if((month >= 1) && (month <= 12)){
            this.month = month;
        }
        if((day >= 1) && (day <= 31)){
            this.day = day;
        }
    }

    private boolean isLeapYear(){
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                return false;
            }
            else {
                return true;
            }
        }
        else{
            return false;
        }
    }

    public void increaseDay(){
        day ++;
        if((day == 29) && (month == 2) && !isLeapYear()){
            day = 1;
            increaseMonth();
        }
        if((day == 30) && (month == 2) && isLeapYear()){
            day = 1;
            increaseMonth();
        }
        if((day == 31) && ((month == 4) || (month == 6) || (month == 9) || (month == 11))){
            day = 1;
            increaseMonth();
        }
        if((day == 32) && ((month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12))){
            day = 1;
            increaseMonth();
        }
    }

    public void increaseMonth(){
        month ++;
        if(month == 13){
            month = 1;
            increaseYear(1);
        }
    }

    public void increaseYear(int increment){
        year += increment;
    }

    public void print(){
        System.out.format("%02d/%02d/%d%n", day, month, year);
    }

    private int getDay(){
        return day;
    }

    private int getMonth(){
        return month;
    }

    private int getYear(){
        return year;
    }

    public boolean isEqual(Calendar date){
        if((day == date.getDay()) && (month == date.getMonth()) && (year == date.getYear())){
            return true;
        }
        else{
            return false;
        }
    }
}