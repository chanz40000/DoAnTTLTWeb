package database;

import model.OrderDetail;

import java.util.ArrayList;

public class OrderDetailDAO implements DAOInterface<OrderDetail>{
    @Override
    public ArrayList<OrderDetail> selectAll() {
        return null;
    }

    @Override
    public OrderDetail selectById(int id) {
        return null;
    }

    @Override
    public int insert(OrderDetail orderDetail) {
        return 0;
    }

    @Override
    public int insertAll(ArrayList<OrderDetail> list) {
        return 0;
    }

    @Override
    public int delete(OrderDetail orderDetail) {
        return 0;
    }

    @Override
    public int deleteAll(ArrayList<OrderDetail> list) {
        return 0;
    }

    @Override
    public int update(OrderDetail orderDetail) {
        return 0;
    }
}
