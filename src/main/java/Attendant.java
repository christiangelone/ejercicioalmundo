public interface Attendant {
    String getName();
    Boolean isBusy();
    void answer(Call call);
    void free();
}
