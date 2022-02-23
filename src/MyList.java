public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size, Object[] elements) {
        this.size = size;
        this.elements = elements;
    }
    public void add(int index, E element){
        if (size >= elements.length) {
            E[] newElements = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
        for (int i = size - 1; i >= index; i--) elements[i + 1] = elements[i];
        elements[index] = element;
        size++;
    }

    public E remove(int index){
        if(index<0){
            return null;
        }else {
            if (index > size) index = size-1;
            Object temp[]=new Object[size-1];
            for (int i = 0; i < index; i++) {
                temp[i]=elements[i];
            }
            for (int i = index; i <size ; i++) {
                temp[i]=elements[i+1];
            }
            Object view = elements[index];
            elements=temp;
            return (E) view;
        }
    }

    public int size(){
        return size;
    }

//    public E clone(){}

    public boolean contains(E o){
        for (int i = 0; i < size; i++)
            if (o.equals(elements[i]))
                return true;
        return false;
    }

    public int indexOf(E o){
        for (int i = 0; i < size; i++)
            if (o.equals(elements[i])) return i;
        return -1;
    }

//    public boolean add(E o){}

//    public void ensureCapacity(int minCapacity){
//    }

    public E get(int i){
       return (E) elements[i];
    }

    public void clear(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }






}
