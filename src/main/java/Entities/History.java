package Entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class History {
    private Integer counter;
    private List<Storage> userCombos;

    public History() {
        userCombos = new ArrayList<>();
        counter = 0;
    }

    public Integer getCounter() {
        return counter;
    }

    public List<Storage> getUserCombos() {
        return userCombos;
    }
    public void add(Combination combo,String answer){
        userCombos.add(new Storage(combo,answer));
        counter++;
    }

    public class Storage{
        private Combination comb;
        private String answer;

        Storage(Combination comb, String answer) {
            this.comb = comb;
            this.answer = answer;
        }

        public Combination getComb() {
            return comb;
        }

        public void setComb(Combination comb) {
            this.comb = comb;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Storage storage = (Storage) o;
            return Objects.equals(comb, storage.comb) &&
                    Objects.equals(answer, storage.answer);
        }

        @Override
        public int hashCode() {

            return Objects.hash(comb, answer);
        }
    }
}
