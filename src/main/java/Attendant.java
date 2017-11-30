public interface Attendant {
    Boolean isBusy();
    void answer(Call call);
    void free();
}
