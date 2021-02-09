package com.paul.learning.wfh.core.strings;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test the {@link SherlockValidString} class.
 */
@SpringBootTest
public class SherlockValidStringTest {

    @Test
    public void validStringBasicTest() {
        String output = SherlockValidString.isValid("abcdefghhgfedecba");
        Assertions.assertEquals("YES", output);
    }

    @Test
    public void validStringSafetyTest() {
        String output = SherlockValidString.isValid("aaabbcc");
        Assertions.assertEquals("YES", output);
    }

    @Test
    public void validStringSmallTest() {
        String output = SherlockValidString.isValid("aabbc");
        Assertions.assertEquals("YES", output);
    }

    @Test
    public void validStringExtraTest() {
        String output = SherlockValidString.isValid("ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd");
        Assertions.assertEquals("YES", output);
    }

    @Test
    public void validStringSingleTest() {
        String output = SherlockValidString.isValid("a");
        Assertions.assertEquals("YES", output);
    }

    @Test
    public void validStringQuadTest() {
        String output = SherlockValidString.isValid("aaaabbcc");
        Assertions.assertEquals("NO", output);
    }
}
