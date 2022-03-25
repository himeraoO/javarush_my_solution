package com.javarush.task.task34.task3410.model;

public abstract class CollisionObject extends GameObject{
    public CollisionObject(int x, int y) {
        super(x, y);
    }

    public boolean isCollision(GameObject gameObject, Direction direction){
        /*
         case LEFT:
                return ((x - Model.FIELD_CELL_SIZE) == gameObject.getX()) && (y == gameObject.getY());
            case RIGHT:
                return ((x + Model.FIELD_CELL_SIZE) == gameObject.getX()) && (y == gameObject.getY());
            case UP:
                return ((x == gameObject.getX() && (y - Model.FIELD_CELL_SIZE) == gameObject.getY()));
            case DOWN:
                return ((x == gameObject.getX() && (y + Model.FIELD_CELL_SIZE) == gameObject.getY()));
         */
        switch (direction){
            case UP:
//                if (((this.getY() - 1) == gameObject.getY())/* || ((this.getY() - 1) == Model.FIELD_CELL_SIZE)*/){
//                    return true;
//                }
//                break;
                return ((this.getX() == gameObject.getX() && (this.getY() - Model.FIELD_CELL_SIZE) == gameObject.getY()));
            case DOWN:
//                if (((this.getY() + 1) == gameObject.getY())/* || ((this.getY() + 1) == Model.FIELD_CELL_SIZE)*/){
//                    return true;
//                }
//                break;
                return ((this.getX() == gameObject.getX() && (this.getY() + Model.FIELD_CELL_SIZE) == gameObject.getY()));
            case LEFT:
//                if (((this.getX() + 1) == gameObject.getX())/* || ((this.getX() - 1) == Model.FIELD_CELL_SIZE)*/){
//                    return true;
//                }
//                break;
                return ((this.getX() - Model.FIELD_CELL_SIZE) == gameObject.getX()) && (this.getY() == gameObject.getY());
            case RIGHT:
//                if (((this.getX() - 1) == gameObject.getX())/* || ((this.getX() + 1) == Model.FIELD_CELL_SIZE)*/){
//                    return true;
//                }
//                break;
                return ((this.getX() + Model.FIELD_CELL_SIZE) == gameObject.getX()) && (this.getY() == gameObject.getY());
        }
        return false;
//        if(direction.equals(Direction.DOWN)){
//            if (((this.getY() + 1) == gameObject.getY()) || ((this.getY() + 1) == Model.FIELD_CELL_SIZE)){
//             return true;
//            }
//        }
    }

    /*
    Метод boolean isCollision(GameObject gameObject, Direction direction).
    Этот метод должен возвращаться true,
     если при перемещении текущего объекта в направлении direction на FIELD_CELL_SIZE
     произойдет столкновение с объектом gameObject, переданным в качестве параметра.
    Иначе - возвращать false. Столкновением считать совпадение координат x и y.
     */
}
