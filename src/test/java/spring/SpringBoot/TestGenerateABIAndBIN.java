package spring.SpringBoot;

import spring.SpringBoot.utils.SolidityUtil;

public class TestGenerateABIAndBIN {
    public static void main(String[] args) {
        String abi = "[\n" +
                " {\n" +
                "  \"inputs\": [\n" +
                "   {\n" +
                "    \"internalType\": \"uint256\",\n" +
                "    \"name\": \"value\",\n" +
                "    \"type\": \"uint256\"\n" +
                "   }\n" +
                "  ],\n" +
                "  \"name\": \"store\",\n" +
                "  \"outputs\": [],\n" +
                "  \"stateMutability\": \"nonpayable\",\n" +
                "  \"type\": \"function\"\n" +
                " },\n" +
                " {\n" +
                "  \"anonymous\": false,\n" +
                "  \"inputs\": [\n" +
                "   {\n" +
                "    \"indexed\": false,\n" +
                "    \"internalType\": \"uint256\",\n" +
                "    \"name\": \"value\",\n" +
                "    \"type\": \"uint256\"\n" +
                "   }\n" +
                "  ],\n" +
                "  \"name\": \"ValueChanged\",\n" +
                "  \"type\": \"event\"\n" +
                " },\n" +
                " {\n" +
                "  \"inputs\": [],\n" +
                "  \"name\": \"retest\",\n" +
                "  \"outputs\": [\n" +
                "   {\n" +
                "    \"internalType\": \"uint8\",\n" +
                "    \"name\": \"\",\n" +
                "    \"type\": \"uint8\"\n" +
                "   }\n" +
                "  ],\n" +
                "  \"stateMutability\": \"view\",\n" +
                "  \"type\": \"function\"\n" +
                " },\n" +
                " {\n" +
                "  \"inputs\": [],\n" +
                "  \"name\": \"retrieve\",\n" +
                "  \"outputs\": [\n" +
                "   {\n" +
                "    \"internalType\": \"uint256\",\n" +
                "    \"name\": \"\",\n" +
                "    \"type\": \"uint256\"\n" +
                "   }\n" +
                "  ],\n" +
                "  \"stateMutability\": \"view\",\n" +
                "  \"type\": \"function\"\n" +
                " }\n" +
                "]";
        String bin = "{\"linkReferences\": {},\n" +
                "   \"object\": \"608060405234801561001057600080fd5b50600436106100415760003560e01c80632e64cec1146100465780635c3fdcd9146100645780636057361d14610082575b600080fd5b61004e61009e565b60405161005b9190610118565b60405180910390f35b61006c6100a7565b604051610079919061014f565b60405180910390f35b61009c6004803603810190610097919061019b565b6100be565b005b60008054905090565b6000600160009054906101000a900460ff16905090565b806000819055507f93fe6d397c74fdf1402a8b72e47b68512f0510d7b98a4bc4cbdf6ac7108b3c59816040516100f49190610118565b60405180910390a150565b6000819050919050565b610112816100ff565b82525050565b600060208201905061012d6000830184610109565b92915050565b600060ff82169050919050565b61014981610133565b82525050565b60006020820190506101646000830184610140565b92915050565b600080fd5b610178816100ff565b811461018357600080fd5b50565b6000813590506101958161016f565b92915050565b6000602082840312156101b1576101b061016a565b5b60006101bf84828501610186565b9150509291505056fea2646970667358221220560a396990a6636d6adc0b948c3280f5b89a2c74a19fd9acc43c04401df2bba264736f6c63430008120033\",\n" +
                "   \"opcodes\": \"PUSH1 0x80 PUSH1 0x40 MSTORE CALLVALUE DUP1 ISZERO PUSH2 0x10 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP PUSH1 0x4 CALLDATASIZE LT PUSH2 0x41 JUMPI PUSH1 0x0 CALLDATALOAD PUSH1 0xE0 SHR DUP1 PUSH4 0x2E64CEC1 EQ PUSH2 0x46 JUMPI DUP1 PUSH4 0x5C3FDCD9 EQ PUSH2 0x64 JUMPI DUP1 PUSH4 0x6057361D EQ PUSH2 0x82 JUMPI JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x4E PUSH2 0x9E JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x5B SWAP2 SWAP1 PUSH2 0x118 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x6C PUSH2 0xA7 JUMP JUMPDEST PUSH1 0x40 MLOAD PUSH2 0x79 SWAP2 SWAP1 PUSH2 0x14F JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 RETURN JUMPDEST PUSH2 0x9C PUSH1 0x4 DUP1 CALLDATASIZE SUB DUP2 ADD SWAP1 PUSH2 0x97 SWAP2 SWAP1 PUSH2 0x19B JUMP JUMPDEST PUSH2 0xBE JUMP JUMPDEST STOP JUMPDEST PUSH1 0x0 DUP1 SLOAD SWAP1 POP SWAP1 JUMP JUMPDEST PUSH1 0x0 PUSH1 0x1 PUSH1 0x0 SWAP1 SLOAD SWAP1 PUSH2 0x100 EXP SWAP1 DIV PUSH1 0xFF AND SWAP1 POP SWAP1 JUMP JUMPDEST DUP1 PUSH1 0x0 DUP2 SWAP1 SSTORE POP PUSH32 0x93FE6D397C74FDF1402A8B72E47B68512F0510D7B98A4BC4CBDF6AC7108B3C59 DUP2 PUSH1 0x40 MLOAD PUSH2 0xF4 SWAP2 SWAP1 PUSH2 0x118 JUMP JUMPDEST PUSH1 0x40 MLOAD DUP1 SWAP2 SUB SWAP1 LOG1 POP JUMP JUMPDEST PUSH1 0x0 DUP2 SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x112 DUP2 PUSH2 0xFF JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x12D PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x109 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0xFF DUP3 AND SWAP1 POP SWAP2 SWAP1 POP JUMP JUMPDEST PUSH2 0x149 DUP2 PUSH2 0x133 JUMP JUMPDEST DUP3 MSTORE POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 ADD SWAP1 POP PUSH2 0x164 PUSH1 0x0 DUP4 ADD DUP5 PUSH2 0x140 JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 DUP1 REVERT JUMPDEST PUSH2 0x178 DUP2 PUSH2 0xFF JUMP JUMPDEST DUP2 EQ PUSH2 0x183 JUMPI PUSH1 0x0 DUP1 REVERT JUMPDEST POP JUMP JUMPDEST PUSH1 0x0 DUP2 CALLDATALOAD SWAP1 POP PUSH2 0x195 DUP2 PUSH2 0x16F JUMP JUMPDEST SWAP3 SWAP2 POP POP JUMP JUMPDEST PUSH1 0x0 PUSH1 0x20 DUP3 DUP5 SUB SLT ISZERO PUSH2 0x1B1 JUMPI PUSH2 0x1B0 PUSH2 0x16A JUMP JUMPDEST JUMPDEST PUSH1 0x0 PUSH2 0x1BF DUP5 DUP3 DUP6 ADD PUSH2 0x186 JUMP JUMPDEST SWAP2 POP POP SWAP3 SWAP2 POP POP JUMP INVALID LOG2 PUSH5 0x6970667358 0x22 SLT KECCAK256 JUMP EXP CODECOPY PUSH10 0x90A6636D6ADC0B948C32 DUP1 CREATE2 0xB8 SWAP11 0x2C PUSH21 0xA19FD9ACC43C04401DF2BBA264736F6C6343000812 STOP CALLER \",\n" +
                "   \"sourceMap\": \"78:556:0:-:0;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;427:80;;;:::i;:::-;;;;;;;:::i;:::-;;;;;;;;543:85;;;:::i;:::-;;;;;;;:::i;:::-;;;;;;;;284:102;;;;;;;;;;;;;:::i;:::-;;:::i;:::-;;427:80;468:7;494:6;;487:13;;427:80;:::o;543:85::-;582:5;610:7;;;;;;;;;;;603:14;;543:85;:::o;284:102::-;340:5;331:6;:14;;;;360:19;373:5;360:19;;;;;;:::i;:::-;;;;;;;;284:102;:::o;7:77:1:-;44:7;73:5;62:16;;7:77;;;:::o;90:118::-;177:24;195:5;177:24;:::i;:::-;172:3;165:37;90:118;;:::o;214:222::-;307:4;345:2;334:9;330:18;322:26;;358:71;426:1;415:9;411:17;402:6;358:71;:::i;:::-;214:222;;;;:::o;442:86::-;477:7;517:4;510:5;506:16;495:27;;442:86;;;:::o;534:112::-;617:22;633:5;617:22;:::i;:::-;612:3;605:35;534:112;;:::o;652:214::-;741:4;779:2;768:9;764:18;756:26;;792:67;856:1;845:9;841:17;832:6;792:67;:::i;:::-;652:214;;;;:::o;953:117::-;1062:1;1059;1052:12;1199:122;1272:24;1290:5;1272:24;:::i;:::-;1265:5;1262:35;1252:63;;1311:1;1308;1301:12;1252:63;1199:122;:::o;1327:139::-;1373:5;1411:6;1398:20;1389:29;;1427:33;1454:5;1427:33;:::i;:::-;1327:139;;;;:::o;1472:329::-;1531:6;1580:2;1568:9;1559:7;1555:23;1551:32;1548:119;;;1586:79;;:::i;:::-;1548:119;1706:1;1731:53;1776:7;1767:6;1756:9;1752:22;1731:53;:::i;:::-;1721:63;;1677:117;1472:329;;;;:::o\"\n" +
                "  }";

        String abiFileName = "leaveMsg.abi";
        String binFileName = "leaveMsg.bin";
        SolidityUtil.generateABIAndBIN(abi, bin, abiFileName, binFileName);
    }
}
