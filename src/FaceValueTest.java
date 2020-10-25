import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaceValueTest {

    @Test
    void testFaceValue() {
        int value = 1;
        for (FaceValue fv: FaceValue.values()) {
            assertEquals(value++, fv.getNumericValue());
        }

        for (int i = 2; i <= 10; i++) {
            assertNotNull(FaceValue.valueOf("C"+i));
        }
        assertNotNull(FaceValue.valueOf("ACE"));
        assertNotNull(FaceValue.valueOf("QUEEN"));
        assertNotNull(FaceValue.valueOf("JACK"));
        assertNotNull(FaceValue.valueOf("KING"));
    }
}