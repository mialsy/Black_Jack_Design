public enum FaceValue {
    ACE   (1),
    JACK  (11),
    QUEEN (12),
    KING  (13),
    C2    (2),
    C3    (3),
    C4    (4),
    C5    (5),
    C6    (6),
    C7    (7),
    C8    (8),
    C9    (9),
    C10   (10);

    private final int val;

    FaceValue(int val) {
        this.val = val;
    }
}
