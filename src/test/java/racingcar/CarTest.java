package racingcar;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CarTest {
    @ParameterizedTest
    @Order(1)
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void 경주중_자동차가_전진하는_경우(int rangeStartRandomNumber) {
        Car car = new Car(rangeStartRandomNumber, 10, 4);
        car.addMoveCount();
        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @Order(2)
    @ValueSource(ints = {1, 2, 3})
    void 경주중_자동차가_멈춰있는_경우(int rangeEndRandomNumber) {
        Car car = new Car(0, rangeEndRandomNumber, 4);
        car.addMoveCount();
        assertThat(car.getMoveCount()).isZero();
    }
}