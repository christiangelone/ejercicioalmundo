import java.util.List;

public class Slicer<T> {

    private final List<T> list;
    private final Integer sliceNumber;
    private  Integer currentPosition;
    private final Integer sliceSize;

    public Slicer(List<T> list, Integer sliceSize){
        this.list = list;
        this.currentPosition = 0;
        this.sliceNumber = 0;
        this.sliceSize = sliceSize;
    }

    public List<T> slice(){
        List<T> l = null;
        if(currentPosition >= list.size()) return null;
        if(currentPosition + sliceSize <= list.size()){
            l =  list.subList(currentPosition,currentPosition + sliceSize);
            currentPosition += sliceSize;
        }else{
            l =  list.subList(currentPosition,list.size());
            currentPosition += sliceSize;
        }
        return l;
    }
}
