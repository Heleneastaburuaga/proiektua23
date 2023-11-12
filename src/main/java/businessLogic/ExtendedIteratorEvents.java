package businessLogic;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;

import domain.Event;

public class ExtendedIteratorEvents implements ExtendedIterator<Event> {
    private List<Event> elements;
	private int currentPosition;

    public ExtendedIteratorEvents(List<Event> events) {
        this.elements = new ArrayList<Event>();
        this.currentPosition = 0;
    }

 
    public boolean hasPrevious() {
        return currentPosition > 0;
    }

    
    public Event previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException("Ez daude");
        }
        currentPosition--;
        return elements.get(currentPosition);
    }


    public void goFirst() {
        currentPosition = 0;
    }


    public void goLast() {
        currentPosition = elements.size() - 1;
    }


	public boolean hasNext() {
		return currentPosition < elements.size();
	}


	public Event next() {
		 if (!hasNext()) {
	            throw new NoSuchElementException("No hay más elementos");
	        }
	        Event nextElement = elements.get(currentPosition);
	        currentPosition++;
	        return nextElement;
	}

}
