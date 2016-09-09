package test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

public class Test {

	private Date date;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Calendar from = Calendar.getInstance();
		Calendar to = Calendar.getInstance();
		from.add(Calendar.DATE, -2);
		to.add(Calendar.DATE, -1);
		Stock tesla = YahooFinance.get("GOOG");
		List<HistoricalQuote> listHistory= tesla.getHistory(from, to, Interval.DAILY);
	
		
		System.out.println(listHistory);
		System.out.println(from.getTime());
		System.out.println(to.getTime());
		
		new java.util.Timer().schedule( 
		        new java.util.TimerTask() {
		            @Override
		            public void run() {
		            	System.out.println("inside timmer");
		            	System.out.println(to.getTime());
		            }
		        }, 
		        5000 
		);
	}

}
