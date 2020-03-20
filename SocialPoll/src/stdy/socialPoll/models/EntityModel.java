package stdy.socialPoll.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class EntityModel {
        protected IntegerProperty id = new SimpleIntegerProperty();

        public EntityModel() {
            this.id.set(0);
        }

        public EntityModel(int id) {
            this.id.set(id);
        }

        public int getId() {
            return id.get();
        }

        public IntegerProperty idProperty() {
            return id;
        }

        public void setId(int id) {
            this.id.set(id);
        }

        public boolean isSaved(){
            return id.get() != 0;
        }
}
