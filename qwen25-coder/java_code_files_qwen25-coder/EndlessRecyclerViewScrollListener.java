public class EndlessRecyclerViewScrollListener {

    RecyclerView recyclerView = new RecyclerView();

    {
        recyclerView.addOnScrollListener(new EndlessScrollListener() {
            @Override
            public void onLoadMore(int current_page) {
                // Do pagination.. i.e. fetch new data, add it to adapter, call notifyItemRangeInserted()
            }
        });
    }

    public static void main(String[] args) {
    }

    class RecyclerView {
        void addOnScrollListener(EndlessScrollListener listener) {
            // implementation
        }
    }

    abstract class EndlessScrollListener {
        public abstract void onLoadMore(int current_page);
    }
}