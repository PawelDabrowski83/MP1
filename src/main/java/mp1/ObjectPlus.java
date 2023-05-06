package mp1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public abstract class ObjectPlus implements Serializable {
    private static Map<Class, List<ObjectPlus>> allExtents = new Hashtable<>();

    /**
     * Constructor.
     */
    public ObjectPlus() {
        List<ObjectPlus> extent = null;
        Class theClass = this.getClass();
        if (allExtents.containsKey(theClass)) {
            // An extent of this class already exist
            extent = allExtents.get(theClass);
        } else {
            // An extent does not exist - create a new one
            extent = new ArrayList();
            allExtents.put(theClass, extent);
        }
        extent.add(this);
    }

    public static void writeExtents(ObjectOutputStream stream) throws IOException {
        stream.writeObject(allExtents);
    }
    public static void readExtents(ObjectInputStream stream) throws IOException,
            ClassNotFoundException {
        allExtents = (Hashtable) stream.readObject();
    }

    public static <T> Iterable<T> getExtent(Class<T> type) throws
            ClassNotFoundException {
        if (allExtents.containsKey(type)) {
            return (Iterable<T>) allExtents.get(type);
        }
        throw new ClassNotFoundException(
                String.format("%s. Stored extents: %s",
                        type.toString(),
                        allExtents.keySet()));
    }

    public static <T> void removeExtent(Class<T> type) throws ClassNotFoundException {
        allExtents.remove(type);
    }

    public static void removeAllExtents() {
        allExtents.clear();
    }

    public static void showExtent(Class theClass) throws ClassCastException {
        List<ObjectPlus> extent = null;
        if(allExtents.containsKey(theClass)) {
// Extent of this class already exist
            extent = allExtents.get(theClass);
        }
        else {
            throw new ClassCastException("Unknown class " + theClass);
        }
        System.out.println("Extent of the class: " + theClass.getSimpleName());
        for(Object obj : extent) {
            System.out.println(obj);
        }
    }

    public static void showAllExtents() throws ClassCastException {
        for (Class c : allExtents.keySet()) {
            showExtent(c);
        }
    }


}
