package data_structure_template.tree.binary_search_tree;

public interface TreeInterface<T> {
    public boolean isEmpty();

    public int size();

    public int height();

    public boolean isContains(T element);

    public void insert(T data);
    
    public void delete(T data);
}
