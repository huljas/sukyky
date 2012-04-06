package com.sukyky.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huljas
 */
public class StockHistory {

    public List<Integer> rates = new ArrayList<Integer>();
    public Date start;
    public Date end;
    public int max;
    public int min;

    public StockHistory() {
    }

    public StockHistory(List<Object[]> results) {
        for (Object[] oa : results) {
            Number number = (Number) oa[0];
            int rate = number.intValue();
            rates.add(rate);
            if (rate < min) min = rate;
            if (rate > max) max = rate;
        }
        start = (Date) results.get(0)[1];
        end = (Date) results.get(results.size() - 1)[1];
    }
}
