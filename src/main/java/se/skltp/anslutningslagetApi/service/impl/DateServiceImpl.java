package se.skltp.anslutningslagetApi.service.impl;


import org.springframework.stereotype.Service;
import se.skltp.anslutningslagetApi.service.DateService;
import java.text.ParseException;


import java.util.Calendar;
import java.util.Date;

@Service
    public class DateServiceImpl implements DateService {

        private static final Calendar dateInPast;
        private static final Calendar dateInFuture;

        static {
            dateInPast = Calendar.getInstance();
            dateInPast.add(Calendar.YEAR, -30);

            dateInFuture  = Calendar.getInstance();
            dateInFuture.add(Calendar.YEAR, +30);

        }

        public Pair<Date, Date> parseInterval(String dateString) throws ParseException {
            if(dateString == null) return null;

            Calendar first;
            Calendar last;

            if (isConcreteDate(dateString)) {
                first = parseDate(dateString);
                last = (Calendar) first.clone();
            } else {
                Pair<Calendar, Calendar> interval = parseDateInterval(dateString);
                first = interval.getFirst();
                last = interval.getSecond();
            }

            rewindToTheBeginningOfTheDay(first);
            rewindToTheEndOfTheDay(last);

            return new Pair<>(first.getTime(), last.getTime());
        }

        private boolean isConcreteDate(String date) {
            return !date.contains("-");
        }

        private Calendar parseDate(String dateString) throws ParseException {
            Calendar date = Calendar.getInstance();
            date.setTime(df_short.parse(dateString));
            return date;
        }

        private Pair<Calendar, Calendar> parseDateInterval(String dateInterval) throws ParseException {
            Calendar first, last;

            if(dateInterval.startsWith("-")){
                first = dateInPast;
                last = parseDate(dateInterval.substring(1, dateInterval.length()));
            } else if(dateInterval.endsWith("-")){
                first = parseDate(dateInterval.substring(0, dateInterval.length() - 1 ));
                last = dateInFuture;
            } else {
                String[] dates = dateInterval.split("-");
                first = parseDate(dates[0]);
                last = parseDate(dates[1]);
            }
            return new Pair<>(first, last);
        }

        private void rewindToTheBeginningOfTheDay(Calendar date){
            date.set(Calendar.HOUR_OF_DAY, 0);
            date.set(Calendar.MINUTE, 0);
            date.set(Calendar.SECOND, 0);
            date.set(Calendar.MILLISECOND, 0);
        }

        private void rewindToTheEndOfTheDay(Calendar date){
            date.set(Calendar.HOUR_OF_DAY, 23);
            date.set(Calendar.MINUTE, 59);
            date.set(Calendar.SECOND, 59);
            date.set(Calendar.MILLISECOND, 999);
        }
    }


