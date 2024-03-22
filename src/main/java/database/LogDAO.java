package database;
//KET NOI db-> tao bang log(id, leved, national...)
//dinh nghia absModel, IModel
//->dinh nghia model=> log

//=> log Dao: login logout, access

//=> trang Ql=> Show (Co the dung database)
//dung server size
//=>detail
//=> xoa(xoa nhieu, xoa 1 record00
// kiem tra request thuoc quoc gia nao)?  ip2location
//=> chuyen tu int sang ip hoac ip ve int de kiem tra ma quoc gia


import java.util.ArrayList;

public class LogDAO implements DAOInterface{
    public void login(){

    }

    @Override
    public ArrayList selectAll() {
        return null;
    }

    @Override
    public Object selectById(int id) {
        return null;
    }

    @Override
    public int insert(Object o) {
        return 0;
    }

    @Override
    public int insertAll(ArrayList list) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public int deleteAll(ArrayList list) {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }
}
