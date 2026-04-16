public class Pilha<T> {
    private Organizador<T> topo;

    public Pilha() {
        topo = null;
    }

    public void bota(T valor) {
        Organizador<T> novo = new Organizador<>(valor);
        novo.anterior = topo;
        topo = novo;
    }

    public T tira() {
        if (topo == null) return null;

        T valor = topo.valor;
        topo = topo.anterior;
        return valor;
    }

    public boolean vazia() {
        return topo == null;
    }
}