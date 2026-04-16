
public class Fila<T> {
    private Organizador<T> inicio;
    private Organizador<T> fim;

    public Fila() {
        inicio = null;
        fim = null;
    }

    public void bota(T valor) {
        Organizador<T> novo = new Organizador<>(valor);
        if (fim != null) {
            fim.proximo = novo;
            novo.anterior = fim;
        }
        fim = novo;
        if (inicio == null) inicio = novo;
    }

    public T tira() {
        if (inicio == null) return null;

        T valor = inicio.valor;
        inicio = inicio.proximo;

        if (inicio == null) fim = null;
        return valor;
    }

    public boolean vazia() {
        return inicio == null;
    }
}
