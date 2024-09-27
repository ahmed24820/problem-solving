package Arrays_Strings;

import java.util.ArrayList;
import java.util.List;

public class MyCalenderTwo {
    List<Event> overLapBookings;
    List<Event> bookings;

    public MyCalenderTwo() {
        overLapBookings = new ArrayList<>();
        bookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for(Event e : overLapBookings)
        {
            if(isOverlap(e, start, end))
                return false;
        }

        for(Event e : bookings)
        {
            if(isOverlap(e, start, end))
            {
                overLapBookings.add(getOverlapEvent(e, start, end));
            }
        }
        bookings.add(new Event(start, end));

        return true;
      }

        private class Event{

        int start;
        int end;
        public Event(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
    }

        public boolean isOverlap(Event e, int start, int end)
        {
            return Math.max(e.start, start)<Math.min(e.end, end);
        }

        public Event getOverlapEvent(Event e, int start, int end)
        {
            return new Event(Math.max(e.start, start), Math.min(e.end, end));
        }

}
