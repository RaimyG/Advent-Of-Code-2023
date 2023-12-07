package day1;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Main
 */
public class Main {

    private static String puzzleInput = "46threevqs8114\n" + //
            "threetwoonez1gtrd\n" + //
            "6ffxbtff\n" + //
            "769twotwo6rv9\n" + //
            "gjrcjrkvghthreegqqrg82qbct\n" + //
            "zkxjhgprtrlcfeight795five8\n" + //
            "99seven3vdcgvmvxtjtwodc5\n" + //
            "three5eightthree3four3vtkkqrgxs\n" + //
            "four863mrrnrsxrkone\n" + //
            "sevenntgvnrrqfvxh2ttnkgffour8fiveone\n" + //
            "49fbsfb\n" + //
            "3rbmlsksg\n" + //
            "ztgszqjjsrtmgqx6572\n" + //
            "3bqnfxkdbonesixseven\n" + //
            "mfgx32ftpbhgngm7\n" + //
            "fzrpfhbfvj6dbxbtfs7twofksfbshrzkdeightwoqg\n" + //
            "2xcftwo\n" + //
            "cshmmltsml4fiveeightdn\n" + //
            "eightthsix1\n" + //
            "two1gvfxcqnrfnbeightthreexznhbmmk\n" + //
            "3917sevenvxqxntcgxskh\n" + //
            "ksctcnfxdsk96drlbjkthreesfqlvnpvfbcbmg\n" + //
            "8nvrmzfs46\n" + //
            "5dbgltmgg1xvtqfkdxsrxzltwo1pgqlqndlc\n" + //
            "eight7four6rpbtmjzj5\n" + //
            "41seven\n" + //
            "gpmfhninexxgqr6\n" + //
            "15sixdrhxzcmqf\n" + //
            "8fivettgmcslxptwofivelckzvfkl\n" + //
            "67ninetjngsrvcpxb8eighteightwofh\n" + //
            "4nine7oneighthm\n" + //
            "njtwonefvhjplkjgvsevenbjg77\n" + //
            "eighthrspkszngkpdtzdpcsmjnvlnhcm9pqmpkxqmbtmbv\n" + //
            "ninehthhgbfsrrbpn2qpcflhgdvh9twotpzkvzmmsj\n" + //
            "6fourzpjthmkrkvqkvvp\n" + //
            "vnrnkfp6\n" + //
            "pfouronefour6\n" + //
            "87fourmznhvmt7\n" + //
            "nxbssjc1sevenvrcjlczct6ninekclbffs\n" + //
            "eightrpzsdggsixthree9dhrnqtjcbxthree9\n" + //
            "pkcmnktzvdjtbbkvxhxpsfp8\n" + //
            "sffd124fkqsq1bd\n" + //
            "txzsmrzlcnnine72kgfkcf\n" + //
            "dbfbdskfdn5nine2sdr\n" + //
            "eightseven47six57\n" + //
            "2eight634sixmlrkhrbslf\n" + //
            "hpeightwopgrqmblthree1fmfnvd\n" + //
            "2jbbf\n" + //
            "vdsbvmjseven4eight195vdkfc4\n" + //
            "five3xjzlrmxvqznine\n" + //
            "nine4vqxmzqxcvfhlm45\n" + //
            "rtwo1\n" + //
            "six8jddkprxvbh98hd\n" + //
            "five5sevenfourfour4\n" + //
            "seventhree4lnxcvdprp66hsjfive\n" + //
            "ninevrxxhgvkghmcs8gsvplvsfour\n" + //
            "6bkeight3fhkfqvvsbcsixljfive\n" + //
            "6sixktwo\n" + //
            "lmscbrnlzmbqpl75ptwo64eightwoxcm\n" + //
            "2sixfivetwoeightdpskxjtlrfive4\n" + //
            "87gfmklvnzfz4594qlksr5\n" + //
            "five3one65\n" + //
            "vxrnhpvrrdd7nqdjfqnhfglfive7qqtzhcrk\n" + //
            "7sixthree441pf16\n" + //
            "11hrfdvdkf\n" + //
            "vst7three2vtwojrkdkjltgdt5\n" + //
            "vqmtwo5\n" + //
            "nffpcvfpjleightfiveeightknmjfive2\n" + //
            "ddfhzdndxvhcgjrcmqq158\n" + //
            "kkeightwo14\n" + //
            "8onetwo\n" + //
            "sevenrslxphqpcpdnxhpzqdf1twoone9\n" + //
            "four8onelgqhkmxktf5six\n" + //
            "8ckshssfour73twoone\n" + //
            "threethree8onefourkkhvfive4five\n" + //
            "64xpzhxtsixseven59\n" + //
            "two8srjslxss\n" + //
            "sixsixninecpgjkfhzdqdjlc48seven\n" + //
            "lpjgghdtgk1sevenzpkmxzqxfourthreethree\n" + //
            "cvznpxfhj2jnlgmnbkdsix\n" + //
            "ninetwo1fournjqvsb\n" + //
            "sxhl3kc\n" + //
            "mtllnjrbscfkdhseveneightgjr4one\n" + //
            "qnineeighttwovjsnvs7five4svdmjt\n" + //
            "bcplhrpvmkxkjxlzl7zkbpdnoneninethreej\n" + //
            "1mbmfktgtwonine\n" + //
            "9threefkptqhhnine2six1fgxnvvfvplv\n" + //
            "8onefourtwoxl42shxq3\n" + //
            "38rlbhvlpeightfivelbcm3jfd\n" + //
            "97one1threexjfsljjz41\n" + //
            "kqmkvmh1three9three74\n" + //
            "3fivenineeightwod\n" + //
            "6sixkgnqqb6\n" + //
            "sevenjdn8csthpjxgnd83\n" + //
            "qhssrppqxlone649\n" + //
            "3gjpsncshmnhkdpzskmmfst3sixfive5\n" + //
            "fivejprgsxddzgcnrn6cpnxnj\n" + //
            "4three3ninedqknine\n" + //
            "61xfrcfseven6\n" + //
            "sfpqbxbdrhqkndfdpldvfive7gxmnthreetwofour\n" + //
            "lbvrzv2onec2six8three\n" + //
            "ninenine2grvzhgtgfourthree98\n" + //
            "1579416\n" + //
            "5fzcbbxzfjjtwo6k\n" + //
            "xmxbtqvnxf665lplnhlgjlkzhkkbknjcxqvkpsp3\n" + //
            "fivefive26fivefour5\n" + //
            "5dbxqcbbkjonehseven\n" + //
            "1k\n" + //
            "8sixqmone9zthx6\n" + //
            "ldsmxpbkkx1rppscjfour3six\n" + //
            "fivethreethreekxzgqmrz8\n" + //
            "lxklrjjmqsix5snb7\n" + //
            "threethreetwothree6\n" + //
            "8three6\n" + //
            "fnine7jmmseven3\n" + //
            "rfhlkhhlx8sjqgclvlsctwo\n" + //
            "vrzpdfjs5fxldpnhvhmmxhleight\n" + //
            "9tmqznszjgrnlhnpxbc\n" + //
            "3sxfscfseventhree\n" + //
            "565vs2\n" + //
            "four86six6\n" + //
            "16\n" + //
            "4vbcrh\n" + //
            "62jrjfrdcldbvjzhp\n" + //
            "onecsqpbrxpmqtrbbtxnrhkdlthree3s1six\n" + //
            "two798tqsjv\n" + //
            "znktgzzmtwo28\n" + //
            "8hllzrjqhvfone\n" + //
            "tgnlbtc2ninejmcsixfour\n" + //
            "fivek1five\n" + //
            "rklpvqfvtwo3\n" + //
            "lgdgchcpcl55hfdmdj\n" + //
            "onesix7onefive9\n" + //
            "jrnthree46seven\n" + //
            "qqptcnrxlllvccssrkkmkxnz8\n" + //
            "cmfour8threelthree\n" + //
            "xfgqc36oneightvlx\n" + //
            "xrvrchbdhftgpn22fgmnhbrscfqrqpgzjmgfive1\n" + //
            "stwotwofourfourthree2\n" + //
            "eightjcfqthcvcgpxxl6j\n" + //
            "cjvfdgmplfeight9\n" + //
            "591eightwoc\n" + //
            "jftninejfb11one1zqpnine\n" + //
            "threeqndgjdfive4fourhgcsbptb\n" + //
            "7pmxvqdhbhf8six\n" + //
            "67zhx64tlnjkvhvv5cblxd\n" + //
            "29zqfive3jkzmbj1\n" + //
            "smvlmnph1seven\n" + //
            "61four\n" + //
            "zjmgnbkoneczgsftnhtvfbtjvbjzpspcffrdkv8\n" + //
            "threesix4\n" + //
            "fhqm8\n" + //
            "ninefour1\n" + //
            "two422dqjqhvhbqkdqf4sixoneightgrd\n" + //
            "llnrdbhthree778dqzrcplfoureight\n" + //
            "eightjblmbgqhrj2onenineszr2two\n" + //
            "8cxbxqssfkzpponeppcqsx\n" + //
            "seventzlsxrskxqm8threecrclkpqjpmeight1\n" + //
            "nine1twonem\n" + //
            "6threeckmkktkvxjteight559ldn\n" + //
            "2zxhldmvpqdcddsxpnnvrvxmc99\n" + //
            "fourone4dzftfnccnvzjdrg49seven\n" + //
            "7eight44\n" + //
            "xmjqm8two47rpjfninethree\n" + //
            "7zhmjjhtrqjcmfprhsix5twobfive4\n" + //
            "rccsqlt8\n" + //
            "seven6three\n" + //
            "lrbp3five19zxb45\n" + //
            "8jlbtllzbtdgzbcfln929\n" + //
            "kdeightlfk9two2fhgshhbzhf\n" + //
            "dvxllmfourpzfpvch7\n" + //
            "four28\n" + //
            "3threefour4hxmfbmjdheight\n" + //
            "6twosphthbbqcltcgxm5ssvqndphrnine\n" + //
            "438rrxntninetwophsix\n" + //
            "eight3eightnine1sevenxsvfr\n" + //
            "4643kntqsvgqqtwo\n" + //
            "two8two\n" + //
            "7gbxkjonetncmeight52\n" + //
            "kg517\n" + //
            "onetwo933\n" + //
            "fbdmpjrjsscsfvfntwofive8tzbrbjsj\n" + //
            "7eightfive9nineninednsfhzvtonepccctxssbc\n" + //
            "93twofour2eight\n" + //
            "7bvzknzdmkjvrxkfngfnsd4foureight5\n" + //
            "onescsxpcfivelmqvfqxmc99vbshtgzjkjfour\n" + //
            "1hvdnine1\n" + //
            "542zhgcmvzcj3threefrvlcc\n" + //
            "sxfc95seven3\n" + //
            "nczqknxn4four7xj81r\n" + //
            "8threefive\n" + //
            "7zvhlf4\n" + //
            "drbxjhqp9gfgxxtkl4\n" + //
            "five2twotklsixfour\n" + //
            "9four9\n" + //
            "2jkeightthreekbqbkffpsztwonine\n" + //
            "3vtffqfkfh9onenine4rqxm7two\n" + //
            "4hlxllh7nrlxcpnrrcfivebkfkjdfjbksnine1\n" + //
            "drgsb3four\n" + //
            "fourhscfkzkjfcdlsjgjrbmlvvcfgcmxtsixjlhfrfmk8\n" + //
            "ncrkhfive1eight1\n" + //
            "8fz3zkhgleight9tqsgnbfoureight\n" + //
            "5six26twoone3two\n" + //
            "ptksmjfkl5twothree4fpshnrcfrmqxeight1\n" + //
            "jfkccclrrr49four6eighttwo5\n" + //
            "threefourgj7eight6\n" + //
            "73slt1one5\n" + //
            "six1zrlfk\n" + //
            "5six17\n" + //
            "qrsix7sixonexmclfz2\n" + //
            "3fivethreebplrfgklj\n" + //
            "xz9sixhlt4eightone\n" + //
            "gkknnbzkt6ffourvrjbfkqz8threesevenn\n" + //
            "2onenine9\n" + //
            "czsgh1five4qtxmtfksln\n" + //
            "eight6fourhpppr\n" + //
            "lpshxfqsddeightqrfgrdn1five6bnr\n" + //
            "5lmmlszndzfoureightqdbhlt7\n" + //
            "9eight5\n" + //
            "8sixrpctqfgf9dm95znhx\n" + //
            "1sixsix6qpmqmtwolh8\n" + //
            "six4threenine2four982\n" + //
            "8jbthree59nine\n" + //
            "q5\n" + //
            "9twosixone9fivehdsvpkttbkcjdbkone\n" + //
            "sixsix4cldngone3four\n" + //
            "9mvsggrgone9gjhfzdmvqbnqzlxgpckg\n" + //
            "gmtqnkdlfv8\n" + //
            "8seven7rxtzksl74four\n" + //
            "bmrtbjzqhbgzcjtwo74fourfourlvj\n" + //
            "twoone4five3twoljrznhdcggone\n" + //
            "42nine1eightseven\n" + //
            "45fiveoneseven6\n" + //
            "mxfoursixone8coned5\n" + //
            "sntmhcsix633seven\n" + //
            "eighttwolrcrl5four\n" + //
            "p22\n" + //
            "1vspmvx\n" + //
            "cpcsx9xgqlmblhshvnsix2hnczvdrrg\n" + //
            "grgtvsqdtslml4tlqrh\n" + //
            "hshgmv3\n" + //
            "fivethree63m3one\n" + //
            "95threecdfhqtmqb\n" + //
            "xjvd14dnfrjthqxvvq1xmqfhv7\n" + //
            "eightnzx48nkqhfssix\n" + //
            "8nzvck4hpfxbstf6fivesix\n" + //
            "4drxbsxgtskqtlnhgrrrz\n" + //
            "6foureightonezbpdbqflp5one88\n" + //
            "twofivefbhfourone4cpnrc79\n" + //
            "5trhksixfivesix2k7\n" + //
            "25three\n" + //
            "1phc9zhhn\n" + //
            "five8ptkczvqk87gkr8\n" + //
            "six61eightfourjjzrktr\n" + //
            "4gxrqrrvkshnpgnrjg2threekpcrfn\n" + //
            "7bclvsb1glbpss\n" + //
            "2eighthdbvxpz\n" + //
            "439\n" + //
            "3drtsf2two\n" + //
            "ninenine8hqqmfvddgspzdsnine7\n" + //
            "xzrjqdlrp2threedrhjztbsvg4mmqvchlhlp3\n" + //
            "99threesixzpgxnseven5one\n" + //
            "2hvst\n" + //
            "twohvrvp164one\n" + //
            "1nine9seven1eight8\n" + //
            "dfkdzprs95\n" + //
            "zthree925fourf\n" + //
            "kssmqhkonetwozcjgvjgxzr3gfdcvgm\n" + //
            "bbsqsix6\n" + //
            "onefour9seven73\n" + //
            "onesevenx1ncpgtczseightssevenone\n" + //
            "419d43dzjlvn\n" + //
            "ninefourb6threezgqvmzklghgsj1\n" + //
            "7crdxpfkcmtqvbvkk3\n" + //
            "8rvp2p\n" + //
            "gnvrlsfjxtfssqz8two6dcfive\n" + //
            "jgtwoneoneseven7oneoneeight\n" + //
            "dfsccdclmffourpsqggngjzn3\n" + //
            "22brtxbtkkdfmkbmv\n" + //
            "sixxlpxqdtwo7\n" + //
            "six8mrvhptlfbmczlnfqrgbvz5d\n" + //
            "84fiveeightsix8\n" + //
            "nine5rzqxp99gmklplmxtveightwombf\n" + //
            "seventhree7\n" + //
            "mfklcxxbhpqsdt2one1\n" + //
            "two7seven2\n" + //
            "63sevenpmdzdrkzjkjzgnnseightjztlvzqhx55\n" + //
            "8twosmrgbzzgmjbnthree\n" + //
            "twosksrj4mk\n" + //
            "onethreeseven4eight\n" + //
            "2kjldqzszg7twolfivethree\n" + //
            "3qdnbnzglheightjtnlqqqt5\n" + //
            "6l4vddmkphgmb3vcbsbgclkzhmmtmfour\n" + //
            "sixvtzmppfssl35eightqc\n" + //
            "six924lt5\n" + //
            "5sixnmmeight7\n" + //
            "mkggvlrdhkjxcr9jcs2fhsptxhj3\n" + //
            "nineggh1\n" + //
            "qzzckckm3\n" + //
            "hxgjhxthreetwo3x4\n" + //
            "7qonejntfsvpcftwogxkvpvbj\n" + //
            "2twoqlg3\n" + //
            "1sixhvsclvhshbr\n" + //
            "seven8tffqvgs\n" + //
            "twobktthxfqqthree38\n" + //
            "397\n" + //
            "lpm9six31seven\n" + //
            "75nrrfxrj\n" + //
            "8sixfour\n" + //
            "ccfbzbjjqlgkbqnxhgd2\n" + //
            "7eighttbrtddvbvrtmxjeight5nine1\n" + //
            "sixfourvbjv5six61two\n" + //
            "sixff4dskpsqsrcd7\n" + //
            "three5five8\n" + //
            "8sixthreethree6\n" + //
            "oneeight7cdjxfmfjbpbjlsevenjgthreexh\n" + //
            "ninetwo4xdxmxpmd86\n" + //
            "eight312\n" + //
            "pmvgbvn8seven\n" + //
            "djrftlbzvfxjjgrh37bmfkone\n" + //
            "ksf53onefourfive6\n" + //
            "7vzqrmklveightnine\n" + //
            "two55eight69\n" + //
            "kbjprbkcgpskbnthree6gznqk5fkttt\n" + //
            "22three37bvmsmjmx\n" + //
            "zpchdzmbjhzl1five26threesix\n" + //
            "2onetdppvzcbzfive29four35\n" + //
            "66one9clqlkbqpfdqkkxv\n" + //
            "lql5four\n" + //
            "two41sevenseventhreeone1seven\n" + //
            "fiverbkxdczfive6smlnbgn6sevensix\n" + //
            "lpveightwoeight9two4frfz54\n" + //
            "twohfkvxqrninesix1\n" + //
            "6twosix\n" + //
            "9ninefive47\n" + //
            "sixsixrjznqb33sevenhkl\n" + //
            "one5nineeight48zqkhjgqlcq\n" + //
            "foureight4seven83\n" + //
            "zzoneightvcnhxlmgjp4ctclzzztwo46six\n" + //
            "2gljzksrvdr21ms\n" + //
            "eight75twofive\n" + //
            "threexdsbjrf6\n" + //
            "lhvrfb3925six\n" + //
            "fgrlrvpnctkdblxvzone2tsxst43\n" + //
            "zpnbvs5foursevensevenjleight\n" + //
            "five89seven4seven\n" + //
            "5rnntxqsngssixonefb3fourdglmstvmft\n" + //
            "tmvldx3eight163\n" + //
            "hmnvbpr6516\n" + //
            "3jfqshjf\n" + //
            "9vgpgcflbbonejhmlncrrjvxdcshdflktr\n" + //
            "vgjmhqnvghc718sevencfdzknkhonesix\n" + //
            "dlzrjfklp3chqxjdpdrv\n" + //
            "eightseven4tcbdhrgssmpvxsxszxrmpzrt7\n" + //
            "five416sixp2\n" + //
            "2threefourj\n" + //
            "hmzoneightmvrksbxbjkvpslkv1tlxxkzsgdseven86four\n" + //
            "pzleightwo774five5\n" + //
            "dvsmtwokrzscgnvztznqh9\n" + //
            "6chqttwo\n" + //
            "67sn3dfdeight55\n" + //
            "4oneightqd\n" + //
            "jhlhcjnd6sixqptqlmrskfive1\n" + //
            "9mfxbvb138zxngghqs43\n" + //
            "2srctwohfplclone928j\n" + //
            "7eightsdsxsskkd8five82\n" + //
            "gccnsvpnfg1195nine\n" + //
            "8584threethreeskzkfpdhz7\n" + //
            "prhhdpfivenine5fsskx5eight7\n" + //
            "9nzhbn7mvczcqcfive7tslfive\n" + //
            "vqxseven5seven4332\n" + //
            "95sevenninefive\n" + //
            "eightzdnddmlrpbxnvxglqnqnr334hpjrl\n" + //
            "one6three\n" + //
            "13dhjftxnp5k\n" + //
            "92threeone3seven\n" + //
            "ncsfdmmft2eightmlfxxdbv\n" + //
            "four3ninethzh\n" + //
            "31five9ksssbdqzlfive\n" + //
            "twokghhrljdc72\n" + //
            "two6fourdktfpddftwoseven\n" + //
            "zgr3bdfqvnkdvpcntkrcfnhpnpdrtkzpthree\n" + //
            "9rnpxdtkbhjbjnf\n" + //
            "1247lqdnsgnp3xtdxnbxkrthfhsrm\n" + //
            "sevendcdbr38ninebljxshxdzqcknvld\n" + //
            "six3gpngxvdqlnrf9gjqjvzeight\n" + //
            "twogfxctgnb4sixqzdmhc2sevenbq\n" + //
            "sevenpjmrj2skcc5\n" + //
            "eightsix9threemxtx13zczqvtvsix\n" + //
            "1tmgrhxzfql9lbpgscnmlcghptbtmpfgct\n" + //
            "2foursdhmtqmfjlf77\n" + //
            "bmgttpr2eight177six9three\n" + //
            "1nmbnkszc\n" + //
            "three14six1lnlfpfmfhm9\n" + //
            "eight4four6five46nine\n" + //
            "26sevengdnoneeightfive\n" + //
            "vhz1fivejzjqnfgrpfbgfz11nlx\n" + //
            "4jnkzktpninejc\n" + //
            "ninefourone1five2four3\n" + //
            "cljtfplrgbv6fsrlfxqmxhtwo75two\n" + //
            "41htzjlzsdbg\n" + //
            "hfnvdnninezhhbsmxfour3ninesevenhdnflzlt\n" + //
            "8vlshckcch57\n" + //
            "28tsbvgmzd\n" + //
            "qccgcsqb5trsvmmdtninehbgsxqjftrvsix7\n" + //
            "3eightkfqlsone\n" + //
            "fgoneightsix4eighteight4one\n" + //
            "8csdgpcbfjbmsixmjztbrqdj5\n" + //
            "9two152\n" + //
            "onevseven1\n" + //
            "vfsjtpzttxdrfive6\n" + //
            "69mdbtdnqgxjmzt\n" + //
            "threemgzspvnvsjone7eightjxssg5\n" + //
            "threelfslcjhhgmfftmftfzsix3qs57\n" + //
            "onejhskmbxcqpkxjxh4threeeightseven\n" + //
            "hhvgnineeight8xrtvmqjnkccdptpvqxlrdkkgljmbnzx\n" + //
            "onezvj2threej5dlnrcbhfxlkkmkpx\n" + //
            "ninepmgbdcvpds3onefive2\n" + //
            "9tblnmmeight1xdmtwo\n" + //
            "cnczmrhjmmcsccnine54\n" + //
            "2fourggjjrxckgvsevencpkgqzzfnptwofivefive\n" + //
            "61threexnrhqbhxb9\n" + //
            "seven14\n" + //
            "32seven\n" + //
            "4cqtssgd3vdxbnllfb2\n" + //
            "smbqxbxgmeightthreeonedsfxfronec2nine\n" + //
            "3145fvqz2\n" + //
            "bgdgbptnr9dqmvvckb\n" + //
            "tpt2ndklfgxtthree\n" + //
            "four16vztcgtwo5xkjmp5\n" + //
            "59onelp\n" + //
            "ztwone9cnvbtpglsq78\n" + //
            "4rmmhxpqsknxhgqmlh9tfzfngqsnbqdmsgtcjsbntr\n" + //
            "4x6lcmrxhhkcscxgxtgpjz33seven\n" + //
            "cnzlsqbvk8sbbzphzkhmeightfive58\n" + //
            "twofour7\n" + //
            "jcsgmrgeightcpzbb8135\n" + //
            "4grxpsix7hgrrhtjvgq68zzbvsn\n" + //
            "qc6\n" + //
            "sgxdninevmmzqdkqmjxpksixfckbjjkgqtwoseven8\n" + //
            "6lhfcjc9\n" + //
            "zkpkjn18six51\n" + //
            "xtnhzzxceight6seventhree27\n" + //
            "qttwone3seven5\n" + //
            "threeone8ksgt9\n" + //
            "8fqkddzb\n" + //
            "nine3sixbprlvxpniner\n" + //
            "dmbvmrthreefcrqvmhp54neightcz3\n" + //
            "twosl6fdtwokrqrqtwo6eight\n" + //
            "8dkrshdpj8threer\n" + //
            "27snqfjdg\n" + //
            "nine7mdsonenine\n" + //
            "threefive2twotktc9\n" + //
            "1twoninesjgqjxphhnineeightthree7\n" + //
            "xxlcmbnctsszkjdhfzqbdr2szvkmscnrg\n" + //
            "tcmsnine6ct\n" + //
            "2tqmkfmc\n" + //
            "sevenpmceighteight1\n" + //
            "hnnthreefourknjznt5nine\n" + //
            "5fhjvttdmzdpkjdsgnpqxlxfninepgrsns\n" + //
            "psxzzdkspgmgnnhkzt6fsdmfour\n" + //
            "1lkb\n" + //
            "seventwo2dglxkrlvgthree\n" + //
            "seven27kzhnknqltvkbxrtvtwo\n" + //
            "7frmrdctninefive\n" + //
            "61twoninebbsbqsbhtxmxkffspd\n" + //
            "3nlzgzlntrk965nine8ljpj\n" + //
            "3pfxjjvcg42lzlkzfs\n" + //
            "7pkztnine54bq\n" + //
            "sixxbxvgsknjxsix4nine3\n" + //
            "fourvbch2cdrsrxzh9\n" + //
            "one1f4mtvslfczm\n" + //
            "456bkzhmxlmhfmkgxrmkbmvhhpmsfk8six\n" + //
            "one9rmbvtdp5oneeightfive8\n" + //
            "67zh4\n" + //
            "83hdqrsxfc2twoninekksg\n" + //
            "1gzmqcrtksixseven81three\n" + //
            "two6threefour2\n" + //
            "nine4rcmbhmhsttgqzfjdm\n" + //
            "jg63\n" + //
            "twofour3one1\n" + //
            "5eight1eightqdmgtszxvx26nine\n" + //
            "482three9seven\n" + //
            "cxdjmjsk1mgqsqkkbq97fourqflf\n" + //
            "bvfplgzj69pqfcpglsix6\n" + //
            "v3458fourcpqkn\n" + //
            "seven769sevenfive9\n" + //
            "dztdmlkjgonejjpxrsevennineninepkc3\n" + //
            "4ninehvgninethree\n" + //
            "tnvgjhzr6\n" + //
            "sevenfour5nineshrsknbbxxsgztrl\n" + //
            "four4flpgsixshxxtmnvxfivensznine3\n" + //
            "73cfxzzsfourzqghjqvkbf7six8qgcd\n" + //
            "fgqk133t\n" + //
            "vjbzpkvsxkoneoneeighteightfive1zrvgqbf\n" + //
            "9six6ntrmhtkgrj\n" + //
            "fournrrmxldk24mxhsevenfive\n" + //
            "8fiveninenine25ninenine\n" + //
            "seven1xb3vbzbqkjdvseightfive6qs\n" + //
            "five8dgqkhldbsfthree7\n" + //
            "six11three5zeight\n" + //
            "hgmqhchrdfivevmftjcgtl5\n" + //
            "oneonesix2bzfsqvkmjzbdq1\n" + //
            "fourx5threethree3mxhgtnine\n" + //
            "hzeightwozfcpkjvfour3three9b\n" + //
            "1oneseven\n" + //
            "hmdtcxld4fdgfgdbjlsevenzrkmnftsevenvsqc\n" + //
            "sevengzpnkfn1sevenjcbfxbg8six\n" + //
            "2sqjnbtskft5\n" + //
            "fknxnxg9944hvtxj\n" + //
            "nine3951\n" + //
            "94sixqslqtxleight\n" + //
            "1zpbxc3\n" + //
            "sixddscq1zxsvgbjnqjj6zknkfczj6fxcqmf\n" + //
            "threetfvhftlzjn72sevenljtwobhgvvsttg\n" + //
            "doneighttwo3vm\n" + //
            "llhzdtwovbxr2\n" + //
            "onemjkvtbsix39eight88\n" + //
            "lhzgpqmhm4ptmcxhseven4eightcrvnqzplrnb6\n" + //
            "3tqljjnx47sixsixmxqbflxjp1\n" + //
            "tkvdxbbsdpkdjl3gtnmjdxhrj5\n" + //
            "qgnnghvnkppvvnine8\n" + //
            "89sixeighthmhsvbsg\n" + //
            "67hqvxtmq\n" + //
            "fiveeighteight7cfmdmfhdld\n" + //
            "nnsxvrgpeightjvcfj3fjeight27\n" + //
            "8ninefourfourcjrbxone\n" + //
            "1bx482\n" + //
            "pponeight1seventllldzgdvgcdmr\n" + //
            "tworrjfkmntbvkpseven4jnrllr4\n" + //
            "ninesixsix9\n" + //
            "csv2ninesixtwo3\n" + //
            "9vzrvg9twokbjcnvcghthreeskfpgssbdxq\n" + //
            "foureight6133rszlz2zvxdx\n" + //
            "6jfklqcdrgm\n" + //
            "3sixhds1kgfvzknhthreefive\n" + //
            "fbgnjqhnghssthzshktxll7rqnhjqjb\n" + //
            "5xjkchhffgz2\n" + //
            "threexjkeight86\n" + //
            "three8eightztthtfvzdxthreethree\n" + //
            "gdxjvzlktltseight5\n" + //
            "twomxfqrxqkrjhs4\n" + //
            "fiveeightnine1ninekhrjbmqhmpjqxtqsjpzbbvnbbzmfour\n" + //
            "nxnrqtsplonefive6zrthree\n" + //
            "8fivejmr1lzbdmvdpdrhvsthpvone2\n" + //
            "2sdfs1threejjxvjxp\n" + //
            "jhkeightskq7\n" + //
            "1eightfive4\n" + //
            "fivefqpmq7twoeightkggxgvrbmbhjdzrmn\n" + //
            "5twozrcnf9fourtmxjtkmfiveone\n" + //
            "hghfivedpgntxbpndqm4\n" + //
            "twodzbplxm9xlgvnmfvxh7oneightzvm\n" + //
            "77eightsixxlvkzfive3\n" + //
            "qrgz7\n" + //
            "eightkdcvchgfourqtrtxtnzeighteightseven1\n" + //
            "69onefivetwoone6\n" + //
            "2onetwothree81qvsmzxpvmpbgsd\n" + //
            "263383seven3rrmskzfgcj\n" + //
            "threeeightthreesixnzgkggflxfour3\n" + //
            "ggk6two2sixeight\n" + //
            "eighteightseven8nine9six\n" + //
            "pzthreenine2nine\n" + //
            "5threefivecpxfjoneightjcn\n" + //
            "mdmhone4ninesix92two7\n" + //
            "nm2twoonerqvckjtxjlzvldq\n" + //
            "6fourzxgncsixninenine4ninethree\n" + //
            "xxflpfeight5nine13qsgrqvsz8\n" + //
            "1threeseven4mvfzm653\n" + //
            "eight23three7dkgdxkrk\n" + //
            "9lqvhv115threezmcnbplgfzjlqmgrpjn\n" + //
            "2pgphcxbglfive5vtldzlrrnx\n" + //
            "dshlq2zcqhzssbdseven5twothree\n" + //
            "eightpvqcqnsprhtvlh5\n" + //
            "789sixtwo3\n" + //
            "eighttmzkfzksd39sevensix8six\n" + //
            "bkk5two\n" + //
            "gkgqxksdpn78\n" + //
            "577gnmbvzf7\n" + //
            "rcfl6foureight4mszdbmkl8one\n" + //
            "17n\n" + //
            "fvnkgxqlpflmmnf8eightsix3twokgj\n" + //
            "lh84twosvptcklvt\n" + //
            "62one\n" + //
            "lmlbfcxpdqlmeight94nineknk\n" + //
            "threenine5three4qqhtfkg\n" + //
            "3nine8threetwoc5ninecxcc\n" + //
            "sgxrhdonefcpone1tsb\n" + //
            "oneqjkppzkpmzcgqv7nine\n" + //
            "lfngqdlhone4rhfsrgdldl5mrpvzr9\n" + //
            "vvvhfbz52eighttbbr\n" + //
            "9threethree\n" + //
            "cnntzjvnplnineeightzdmtsx6\n" + //
            "4ninefourdndsvnbthree\n" + //
            "3zbt3nine28\n" + //
            "1seventhreedfggtfvvsngszlsix3\n" + //
            "six13nine14\n" + //
            "9gjzdmdzssixone\n" + //
            "nnxbmrdmjdhrjnhktlprtbvknninefive3662\n" + //
            "6rrmxmfm479tcxmvk\n" + //
            "ninedfchdzxbmlrjkckkjpqqxchz58\n" + //
            "three22sixeightrbzmdlfztwo\n" + //
            "jqljmhxgmfxkgsevenone77ffour\n" + //
            "9xbphsix\n" + //
            "onetwo271sixninek\n" + //
            "sevenbdxtwofivexscbkflmkncvh7\n" + //
            "jxlqvscdjz7six62\n" + //
            "six4five\n" + //
            "eightsevensixone7eight\n" + //
            "five4five9\n" + //
            "btsjninegdrcbxdrgmmg23q\n" + //
            "67mqtphlkhtp\n" + //
            "3drdmqx77\n" + //
            "8twoninenine\n" + //
            "eightfcng16kzgtfzbdfxbltn113\n" + //
            "fc68\n" + //
            "3rkqrhlskj8one8\n" + //
            "eightqtkls21five99\n" + //
            "41clcg5qmfkdkq6snghpone\n" + //
            "pdmnvqhg8vjrvlld9ninexcglqpgm62\n" + //
            "7one4two2ninencplhmrztsqjgt\n" + //
            "6cvdc\n" + //
            "2sixone76eighthqrlmfxzk\n" + //
            "six512nrsstwoeight\n" + //
            "2fourfourqlctwo\n" + //
            "sixb23seven3eightcbmvk\n" + //
            "jxthree1bvtwombbmcdbsbf\n" + //
            "eightzdqnjbjzd9sevenflcqqflk\n" + //
            "four88sixtwotnmzrltlnineoneddrsxk\n" + //
            "9six5\n" + //
            "5ninegfhvsqblftwogmmfgddncqfmqjtqvbc6\n" + //
            "9svv5jlfbrvpntgpqkkg68\n" + //
            "khglrpxfqqfour4\n" + //
            "qkfour1sixfnpzxkdzr\n" + //
            "22onefivemhsxvhllnzr2\n" + //
            "1onehpdqbrklhg\n" + //
            "bs6sjsndrz2\n" + //
            "8five9\n" + //
            "ninetwo3five5xmpkzrnqzq5\n" + //
            "2797two2\n" + //
            "91tdmpxtrkfourq7fourcvtbmsk\n" + //
            "four82\n" + //
            "three3sjgxtp86eightwof\n" + //
            "sszzthsixvrdbglczld3\n" + //
            "four1fourfour5sqknhn\n" + //
            "vlhzqfbht8px7kznvtffourq\n" + //
            "jshqhczgr3\n" + //
            "4two1fvvxdfms\n" + //
            "seight3fghflv\n" + //
            "tgqdzsdzdthree787\n" + //
            "45nrdlxtqggcseveneight\n" + //
            "87tkbsmfvhl5five3zqx\n" + //
            "6rmpdxvrlszpjtqmhcd\n" + //
            "fourtwothree49346eightwohq\n" + //
            "9kkgdv\n" + //
            "ndoneightsevenfive8\n" + //
            "threeonecc63pvgxd7\n" + //
            "ctwone8zbxbf\n" + //
            "foursevenrpkshs75two8one\n" + //
            "2jsvxtrrkjxjzxmh\n" + //
            "nkf8three\n" + //
            "gzbplsixeight86lxpcrzxpbx7seven\n" + //
            "5pzpfs\n" + //
            "six12ssffeightfourfivefive\n" + //
            "one2four71\n" + //
            "5onebhrjgrrltbsix\n" + //
            "hclv99two89nsfdfour4\n" + //
            "8qk8fbflndsix9\n" + //
            "lmvcprone16\n" + //
            "rknqlczt15thqlpvk4pgllfmsix16\n" + //
            "seven8jgpq427sixtwo1eightwokb\n" + //
            "nine8xgghnfive\n" + //
            "nineeight7ninefourrtbtd\n" + //
            "threetwothbdmvtcrjgsm3fivehdqlxtxnkdstgs\n" + //
            "4sevenfourvrqfkhspbkqjcxjkjfniner\n" + //
            "5three69mzqfqrhrjdqhbpmscz\n" + //
            "478kj1\n" + //
            "5bhcrpjtvjsxpskmscxclpzxkzc8five\n" + //
            "sevenhlxgzntwo4knxtcqscdone1\n" + //
            "three5dmjg\n" + //
            "ssxtz342sevenfivefive7\n" + //
            "84two9vsqlbh5fivefour\n" + //
            "4fiveninetwo\n" + //
            "8cqz\n" + //
            "twoptxmcmnsbgrrndfdgtwo2ppglmzcfour\n" + //
            "hdqfnlzrscveight5plplhvbg\n" + //
            "sevenmgxjzjtwonine5\n" + //
            "2thfbhzjsdk\n" + //
            "jmzsvtqjxmgstbqctdv8qc\n" + //
            "gv8glpnsixninesxhzbmfqxkqfd8eightwonj\n" + //
            "88vsqztnhst\n" + //
            "sixgf2sssrzvqlsm9one26twonedzq\n" + //
            "4five611one\n" + //
            "sixdvbsctpqbqfive6\n" + //
            "one3c\n" + //
            "xcnkrcdxtfivefour3nine\n" + //
            "7srqvlkftzztpgrfive2threesix3gtzcnfdvs\n" + //
            "3hqsevenlzgbf\n" + //
            "cggclvfppfive1dgnnqgzqzsdhdpbg\n" + //
            "noneight9tktnzqnttwo9fivenine\n" + //
            "2nfourfourmmfltjvxzfivezfntcxfctqsdckcjl\n" + //
            "htzvlsixsix8twoone\n" + //
            "91xnrqfdqsbrvf6sixtfour\n" + //
            "hvtwonenzqnine9fourvtcdndzptfourx\n" + //
            "sixfiverp8fourbnfgnlkqld\n" + //
            "1728\n" + //
            "18nineonejhbvdbm22jgrbsgf\n" + //
            "2rcpqxgsix8fivebscvblxzcmbztrlsx\n" + //
            "9threetwoeightxbsrxpjns4zkpztwo\n" + //
            "six6sixfive\n" + //
            "zpqjsckrcztv5\n" + //
            "3nvsixdnmfqplqtqpq9\n" + //
            "onesixeightthree6nine74\n" + //
            "66sdh\n" + //
            "235lmnrgxztt2nctntsgfive57\n" + //
            "fivegnzfnbfpvnl72fournine\n" + //
            "3jrfive9srqvsxxfz\n" + //
            "vs4threeeighttwotrcpphdq\n" + //
            "zlfcpfptwoninescshbtcdv58sixrkxfour\n" + //
            "eightfour8\n" + //
            "4onesfkbnnfsevensix\n" + //
            "fourhjsbvjgqhrvtdvmrzrtsixpglhrlcrrkr2\n" + //
            "fourthreedczqpjskdsqnnhczhdc47\n" + //
            "3sevenfourtwobn\n" + //
            "3fivesix1\n" + //
            "4qbtlplbl25\n" + //
            "66grjtlgsbflfjbcdmdnnine6\n" + //
            "1rbszctwo7pkmvsixsevenoneightqc\n" + //
            "snpvmbppvtwofiveeight1rnmfkrsfbhs\n" + //
            "5frcvcsixmlhfcv\n" + //
            "2nbd\n" + //
            "557sevengrvxddpdgfzsqsqx6three\n" + //
            "five41lrlkdmhsbjq\n" + //
            "eight3vzzgspkgqh4eighteightstthdqm\n" + //
            "vqctjspmq9\n" + //
            "four12clqrgts\n" + //
            "45two8zv\n" + //
            "c4xklll3\n" + //
            "four3hhfivedtj\n" + //
            "six55two3\n" + //
            "gxdttwo256\n" + //
            "njthree45\n" + //
            "7threevl5174\n" + //
            "bkvcbfournine6seven\n" + //
            "four8jjg\n" + //
            "725rgkxrztbhjmsbxgvc2\n" + //
            "ninetjqd48\n" + //
            "xbpthl9x\n" + //
            "1sbf8seven\n" + //
            "qfsbld6five7four18\n" + //
            "9kvbcnlctngbthqlbqlbfhttmf51\n" + //
            "98eight3vfcxzbsvfour4one\n" + //
            "tlbpdxbglrcqppkcb6two6rbffxpzmnntpdr\n" + //
            "fivevgnzjkjcfeight7twozvseven\n" + //
            "vjmdjsrl8onetrnlgsclrfmpvkdblfourktwonet\n" + //
            "tvvkszfvnineeightninetwo9\n" + //
            "2twollqsbnconescjjj\n" + //
            "one23qz\n" + //
            "nine2vbglpdpvfhrqp8eight\n" + //
            "threeone7seven\n" + //
            "vxxone8onetbgplp3\n" + //
            "two1mlqrfour7\n" + //
            "ninezdkbvkbonetmzxgszqxdnttkgsgqd7eight\n" + //
            "vrfbzcfourfivenlgmvktszpthreepqkgfnjfc9rfmkxbv\n" + //
            "ninezhsfngmbc5fivers\n" + //
            "tzjxrncfnine1cglgmnmxhssevenbdmxfjtg\n" + //
            "sevenseventwo5five9seventhreeflvgdbstfr\n" + //
            "7rggpvgkmone\n" + //
            "1veight\n" + //
            "41vk7two5\n" + //
            "7onetwoone6\n" + //
            "kvm25nine\n" + //
            "onekzcjprtxbncpqchpxpvtttvgmqfour3pxpcmfourtwo\n" + //
            "chrrlnddfivefive5\n" + //
            "ttvnlchqz8hrxhmgqrfour9rmkkdlr14\n" + //
            "5jcmdfnldlq\n" + //
            "6431khcknnine7\n" + //
            "onegtmzngkqgfggfmhxshnzltdbkvmkjjvnfpkclhxntvngvlnqd3\n" + //
            "q4fzzrpt\n" + //
            "cllbnine5\n" + //
            "six18ddmk22six\n" + //
            "2knsdjp2nphnonesevenfive\n" + //
            "vqjkllm1threemfrnlvrmjzzsnhmxsxtwosgxjgjcqrtwo\n" + //
            "six4onefhpxkpnqfivekbxhmxtbx\n" + //
            "djsptzspn3eighthb9nthreelhpzd\n" + //
            "twofdvrmxrcmfive27zdcssbvcsthree\n" + //
            "5eight5ptfgcnthree1zjvkk3l\n" + //
            "3one8two\n" + //
            "bsdphtbdfour1twosevensevensix92\n" + //
            "four7six4smppkbtwo4\n" + //
            "87dpqjbbtwo78662\n" + //
            "1ninefour8four32\n" + //
            "232spbt1jfzfourthree\n" + //
            "3cxxkqldtwosevenninetwomcdvls7\n" + //
            "5seven7pgnkdjgckfive\n" + //
            "rvmfpjs2threespszkcvfklpdhtmbnseven2seventjrhx\n" + //
            "eightfive3twonbxs5\n" + //
            "3frglvrm32\n" + //
            "19778gmtrsjkcrdqlptpjzg\n" + //
            "zpvskbdztrone5eight3sixnmcpdshrgblddrht\n" + //
            "7seven2tdnblk782eight\n" + //
            "mjjldone2cqmlmmzxbt\n" + //
            "hfponeightoneplk66threezzklrkrmvronekhqsrnvm\n" + //
            "lghjkgdssfour423sevensix\n" + //
            "sevenfmqtwo1onecmrhrzhl\n" + //
            "dmpf2fivethxhpss27jn\n" + //
            "2lnpfrdfour6x\n" + //
            "onetpztmmfr2\n" + //
            "66qlzhrrlchcxznsjrfxqxkone\n" + //
            "9fivenlzrgm\n" + //
            "mstbglvtxnzlnhjrltwo238bsfourczkvctl\n" + //
            "zkz6dcdsfgssl8b\n" + //
            "cgnqsdeighteightfourhnpkdvggdsixfour3\n" + //
            "96xschgpnlktsix4eight537\n" + //
            "31c\n" + //
            "4smrxzzpvqmrxhmltcmgq8zrxftd38\n" + //
            "onemncsrqlklxdx9ngpbxhxpk7\n" + //
            "gzr2sevenhjsczr5twoqsmhj\n" + //
            "nkfh4eight9gzpkvvxjsqfjbt\n" + //
            "two2nine\n" + //
            "cxxqmzfnm3mbsmltpkpfour6fourfrjjcztt5\n" + //
            "lxnqtpzldptcvnlcggonehndzmx7863\n" + //
            "3fmgl36lbcvrrczdfqdss\n" + //
            "fourfour4xjxgmnctwothree\n" + //
            "nineseveneightgrdvffkntwo948\n" + //
            "fouronenine8\n" + //
            "8xfktsxszhn53\n" + //
            "6onedgffr57\n" + //
            "krmvzbhctztlpfour9fcmdscctdhsf535\n" + //
            "fbjgdrzxv1four573vljtseven\n" + //
            "8three9ngrjrhh\n" + //
            "1gqfoneninegzpbjtbd74\n" + //
            "6vkf\n" + //
            "9eightzmfsbxqttg1one\n" + //
            "56k9ninerqprllq\n" + //
            "jnhlpkbxvm6three6seventwonegp\n" + //
            "j929\n" + //
            "sevensixnxgbtfksix5fbdvgkbd77\n" + //
            "39sevencpdcbnshpcsevenhggbcthree1znldhfngnk\n" + //
            "618fourtzfrql\n" + //
            "kldcjxktwo5fivetwoninehsbmrgtn\n" + //
            "msvjzqteightthree3\n" + //
            "2xtvr581xsbctkfftjprmb\n" + //
            "seven13dvstp848dsbllng\n" + //
            "sevencqhmth7tdshrtrphx9\n" + //
            "three2eight8six6\n" + //
            "fourprlhnl7vczqdtl8bjmncrrfpzk\n" + //
            "5four1one5\n" + //
            "seventhreethknine5\n" + //
            "two6vqgpzvmhlhfourklvxvhmnlqnmrhknstwo\n" + //
            "4bvxhmfz2bktbfltj\n" + //
            "nk9\n" + //
            "xjb713vmxzcfxl3ninegkjrcq\n" + //
            "rrmplxeight1znine\n" + //
            "zsjgngpfourfoureighttwo1\n" + //
            "99twojqzlggpseven\n" + //
            "eightfivetwo7\n" + //
            "8ninevlkxsptd2ninenine\n" + //
            "4hrzzjxp26sixpxjxphmkpc8\n" + //
            "vlqsf4ntssmfrz\n" + //
            "eight93tflqhb9two76six\n" + //
            "ttxfgqtrfournine9pqqgd\n" + //
            "7274mmjgcssvrsix\n" + //
            "1threesix5dmkdtjsmptthreeqgfgsix\n" + //
            "msrtbbschxmvcm2ctprdlnkdzthree\n" + //
            "dztlvgn3two\n" + //
            "h7crsblhtp\n" + //
            "seven5eight7qrgxlninethreetwobbsjdbxcvt\n" + //
            "2hfbeight\n" + //
            "eightrdlfourtwo3vzrlsbcjndnineone\n" + //
            "ljxbtvhztkkb4three94fiveeight\n" + //
            "3fourkbpmpctthreetwovzhgq\n" + //
            "6xznbcgdmng\n" + //
            "3jl5zlkbjpeight1tvmrqdlk\n" + //
            "23sjvtghccsevenninesixzlhgzqtkhb\n" + //
            "xptf34eightp4cdqcv\n" + //
            "gfneighthvf3nine\n" + //
            "threeeightthreenineninethreetwoone5\n" + //
            "9nine22qdfzgbdsd7two\n" + //
            "gfourtwotbxddnxzc2\n" + //
            "four84gxllvp76four\n" + //
            "t86\n" + //
            "nheightwofive525two\n" + //
            "hh115\n" + //
            "lqvxpsxthreethreefive34three\n" + //
            "sgvqhjqdvtzfnine6bgjcbn2tqrvgfmdtdbh\n" + //
            "nine2seventwop\n" + //
            "7hllxxndzggvsrsh9zrktwoone2rxqczzbqpx\n" + //
            "s2one574\n" + //
            "9fourseventzqfseven\n" + //
            "62six1jdqcnqm4sixjsjvnx\n" + //
            "five6fpktwo1l3\n" + //
            "five1d2\n" + //
            "fbnoneightknthree6\n" + //
            "4fbtxqsix6dxpjclhtlk\n" + //
            "8vggprkfjrpqz8hhlvffmfiveone8\n" + //
            "rz29eightfghseven\n" + //
            "two9four98cgmntgcncsmppz\n" + //
            "bmrvhsz4twotwo\n" + //
            "1oneeightthreeeightfourtwo\n" + //
            "fivethreefvz9rzvzdqxqbmtxcnqc\n" + //
            "3oneqvseight56lkxjk\n" + //
            "6l99six\n" + //
            "dsevenninefour48kjs\n" + //
            "1sixxvrsevenone7\n" + //
            "lpmdghtcdj3nine28g77glk\n" + //
            "tnkhrdone1hhtfzhnz\n" + //
            "4cpzzht\n" + //
            "foursixlmtmvrptqonejmssjldcnz8one\n" + //
            "1bnd5slzddmkmvthreep4three\n" + //
            "7jlrm\n" + //
            "seventhree3\n" + //
            "vmjsix8sevenktbrxnftfour\n" + //
            "gmczxbkcgsixseven6six\n" + //
            "9oneone2hhnj8\n" + //
            "bbpeightjbtp4qfpks2four\n" + //
            "twoeight3\n" + //
            "7mqnzkddm3hrqvhdvzgvgbnfcjtfour\n" + //
            "4onesixgkcsix\n" + //
            "chmkonenine1btgnldh\n" + //
            "dpxzrthkjzdfkgpkdfvxveight5\n" + //
            "hxlfiveeight6\n" + //
            "3xlkg23fivethreesixeightksmc\n" + //
            "nfourrjdqx4four6\n" + //
            "ptzrcdzthreer3phpkqlftwo24\n" + //
            "five7sevenjpjmmppfive\n" + //
            "11sevenfivezcglsdkhqffivethreeseven5\n" + //
            "4eight5mjlkzrgnmlnmxntqmtlxmqlkjccttcpmgznfouroneightk\n" + //
            "1oneightx\n" + //
            "25fivevhtpblpfthreefour2xrzsix\n" + //
            "eightfour41four8fiveone3\n" + //
            "pxmrbcqt22vfvzvvp4seven3\n" + //
            "3zqbqnnonesxtgz9eightonepqnld\n" + //
            "d2six5dmlqczzrtp79brzzq\n" + //
            "nine48\n" + //
            "ninevbjkjcd11qhtvb\n" + //
            "six4nine1four2three5\n" + //
            "lcnvnxgzssonethree5mnvlsevenclrcpxbjbzvhlj9\n" + //
            "8onethree6n1\n" + //
            "98ddgtwov6nzvjzsscd\n" + //
            "bklvmzjrqgfqx7\n" + //
            "5eight95ninetwo8\n" + //
            "qcrgbmzlztvtzrsjsixmvps2\n" + //
            "jsnmkd9seveneight\n" + //
            "mkdzj28twohhmkctnsix\n" + //
            "kb38sixttdhv9three\n" + //
            "8eightninetwo\n" + //
            "twoppvc7\n" + //
            "sixfour5sj6cdfjsskfb\n" + //
            "242p28mxh8zrkvzp\n" + //
            "sixnine5kqqrhxms\n" + //
            "21sixfivepmspvnbscjc\n" + //
            "threetjgcjpvflndq98\n" + //
            "sgonefivefive8\n" + //
            "nine5sevenfouronedsqpkgpthbeight3hrfdmcql\n" + //
            "1sixkhqpcv5\n" + //
            "bsnnone3\n" + //
            "46sevenbnfsgnjldbtjnsjlmhvjrp8sevenx\n" + //
            "twotwosevenonelzlpnmkdqq2rqthff\n" + //
            "sixfournbzqfhff6jdlfhpt974\n" + //
            "5sixnvs2trqprv\n" + //
            "nine8ninefourninelgcxntninektmhgjqrpd1\n" + //
            "hsjmpqkpkqzjnmgbz2nine6four\n" + //
            "6two7jzfivethree25four\n" + //
            "twobxtwosixfbhj5prfntlmfour\n" + //
            "4lfsevenxsvvlmbzcnprsix\n" + //
            "45lxtrdvsgfzzcmzjz7ninenvcvc\n" + //
            "qfzvfthree9\n" + //
            "sevenlxfzcsevenseven4\n" + //
            "sjpqvfmx9twonep\n" + //
            "qsljtpgdprjbkgzcnv5seveneightseven\n" + //
            "zmhdkvltbxv3qftmt143\n" + //
            "5sevennh68\n" + //
            "sevenfour6rg\n" + //
            "1sixonesixfournbbz9hfeight\n" + //
            "sevensevenfour265one\n" + //
            "88sixtwo\n" + //
            "one5rcczjeightknjeight\n" + //
            "qgftwohszlmfgjnn7\n" + //
            "xbtcpx3htlseven\n" + //
            "7tnmvjdj4zlltljq8pdlnfghnd\n" + //
            "jcpcgznmmnine4ninenine\n" + //
            "zvdsbmlvn5four555\n" + //
            "threejpnbcbttggm9onefour4vtjhdfjsnz\n" + //
            "7x7\n" + //
            "veightone1\n" + //
            "eightjlkckhqjfonesix94twoeightvggdqxgcn\n" + //
            "2two2fdzkxgfour9sjtfourvxklldpvjm\n" + //
            "849ndjngjhs65hgvdbcxps\n" + //
            "fiveeightsevenseventfqzdxnhxkxgmnqmdjmxmdc35\n" + //
            "4sevenqnhvszlfour\n" + //
            "seightwozbjkfsgk5three1tcpbshgfzeightfive\n" + //
            "fourgxmqgpgbtwo4\n" + //
            "4nine9\n" + //
            "twokfvsvfgdtmtwom2xlkjseven\n" + //
            "9one43ninedrtznff\n" + //
            "zlfive98rfpmnsevennljlhbxhcn\n" + //
            "lmfgxfdsevenchrkbhxlrrssbcqqf7fivectglcvrsrg8\n" + //
            "6twofive3two\n" + //
            "mchm6\n" + //
            "mbvtbcjvv33rqfsllshb\n";

    public static void main(String[] args) {
        Integer resultPartOne = partOne();
        Integer resultPartTwo = partTwo();

        System.out.println(resultPartOne);
        System.out.println(resultPartTwo);
    }

    private static Integer partOne() {
        String[] puzzleInputRows = puzzleInput.split("\n", 0);
        Integer total = 0;

        for (String row : puzzleInputRows) {
            // Extract all non numeric chars
            String numberOnly = row.replaceAll("[^0-9]", "");

            char firstDigit = numberOnly.charAt(0);
            char lastDigit = numberOnly.charAt(numberOnly.length() - 1);
            String number = new StringBuilder().append(firstDigit).append(lastDigit).toString();

            total += Integer.parseInt(number);
        }

        return total;
    }

    private static Integer partTwo() {
        String[] puzzleInputRows = puzzleInput.split("\n", 0);
        int total = 0;
        String[] numberStrings = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        String[] numberInt = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

        for (String row : puzzleInputRows) {
            HashMap<Integer, Integer> numbersFound = new HashMap<>();
            String finalNumber = "";

            for (int i = 0; i < numberStrings.length; i++) {
                String findString = numberStrings[i]; // findString = "zero", "one", "two", ...

                int indexMatchString = row.indexOf(findString);
                while (indexMatchString >= 0) {
                    numbersFound.put(indexMatchString, i);

                    // Start the new match by ignoring first occurence
                    indexMatchString = row.indexOf(findString, indexMatchString + 1);
                }

                String findInt = numberInt[i]; // findString = "zero", "one", "two", ...
                int indexMatchInt = row.indexOf(findInt);
                while (indexMatchInt >= 0) {
                    numbersFound.put(indexMatchInt, i);

                    // Start the new match by ignoring first occurence
                    indexMatchInt = row.indexOf(findInt, indexMatchInt + 1);
                }

            }

            // At least 1 match
            if (numbersFound.size() > 0) {
                // get the lowest key => get the first digit
                String firstDigit = numbersFound.entrySet()
                        .stream()
                        .min(Map.Entry.comparingByKey())
                        .get()
                        .getValue()
                        .toString();

                finalNumber = finalNumber.concat(firstDigit);
            }

            // At least 2 match, to avoid value appears twice
            if (numbersFound.size() > 1) {
                // get the highest key => get the last digit
                String lastDigit = numbersFound.entrySet()
                        .stream()
                        .max(Map.Entry.comparingByKey())
                        .get()
                        .getValue()
                        .toString();

                finalNumber = finalNumber.concat(lastDigit);
            } else {
                finalNumber = finalNumber.concat(finalNumber); // First digit is also the last
            }

            System.out.println("ROW : " + row);
            System.out.println("FINAL NUMBER : " + finalNumber);
            System.out.println("----------------------");

            if (!finalNumber.equals("")) {
                total += Integer.parseInt(finalNumber);
            }
        }

        return total;
    }

}