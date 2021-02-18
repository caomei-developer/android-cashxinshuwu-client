package com.xinshuwu.util

class SignatureUtil {
    var consumerSecret = "cCEc0PPno08rFDwP"

    fun addBookShelf(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("cID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString5)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun addCommentFuli(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun addDayRead(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("doWhat=")
        stringBuilder.append(paramString4)
        stringBuilder.append("minutes=")
        stringBuilder.append(paramString5)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun afterDaySign(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("nDay=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun aliFuzhu(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("itemID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("rmb=")
        stringBuilder.append(paramString5)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun bookType(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("doWhat=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString4)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun bookcata(
        paramString1: String,
        paramLong: Long,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bID=")
        stringBuilder.append(paramString2)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("isUpdate=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramLong)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString4)
        paramString1 = stringBuilder.toString().trim { it <= ' ' }
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun bookcolumn(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("columnID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString4)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun bookindex(
        paramString1: String,
        paramLong: Long,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bID=")
        stringBuilder.append(paramString2)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("lmID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramLong)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString4)
        paramString1 = stringBuilder.toString().trim { it <= ' ' }
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun booklist(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun booksorts(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("prefer=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun buycart(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bList=")
        stringBuilder.append(paramString3)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("cost=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString5)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun changeTask(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("doWhat=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString4)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun commbooks(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String,
        paramString8: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("pn=")
        stringBuilder.append(paramString6)
        stringBuilder.append("prefer=")
        stringBuilder.append(paramString3)
        stringBuilder.append("rank=")
        stringBuilder.append(paramString5)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString4)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun currency(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun delBookShelf(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bList=")
        stringBuilder.append(paramString3)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun detail(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("goID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun downbatchfree(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String,
        paramString8: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("batch=")
        stringBuilder.append(paramString4)
        stringBuilder.append("bID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("cNoList=")
        stringBuilder.append(paramString5)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString6)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun downnum(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("cID=")
        stringBuilder.append(paramString5)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun editUserBirthday(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("newUBirthday=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun editUserName(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun editUserPhone(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String,
        paramString8: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("dCode=")
        stringBuilder.append(paramString5)
        stringBuilder.append("pNo=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("vCode=")
        stringBuilder.append(paramString6)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun editUserPwd(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String,
        paramString8: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("dCode=")
        stringBuilder.append(paramString5)
        stringBuilder.append("pNo=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("vCode=")
        stringBuilder.append(paramString6)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun editUserSex(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("newUSex=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun editUserSig(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun elitebook(
        paramString1: String,
        paramLong: Long,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("page=")
        stringBuilder.append(paramString2)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramLong)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun evokebatchfree(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String,
        paramString8: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("cID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("cNum=")
        stringBuilder.append(paramString5)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString6)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun evokeselectfree(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("cNoList=")
        stringBuilder.append(paramString4)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString5)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun freshGitt(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("doWhat=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun getSMSCode(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("country=")
        stringBuilder.append(paramString5)
        stringBuilder.append("dCode=")
        stringBuilder.append(paramString4)
        stringBuilder.append("pNo=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun getUserCountry(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("doWhat=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun hdBalance(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("pn=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun hdUnlock(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("doWhat=")
        stringBuilder.append(paramString5)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun hotbookss(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("prefer=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun imeiadd(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("imei=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun inviteInfo(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun inviteList(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("pn=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun keyBooks(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("pn=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun listcommbook(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String,
        paramString8: String,
        paramString9: String,
        paramString10: String,
        paramString11: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bt=")
        stringBuilder.append(paramString5)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("pn=")
        stringBuilder.append(paramString9)
        stringBuilder.append("prefer=")
        stringBuilder.append(paramString3)
        stringBuilder.append("rank=")
        stringBuilder.append(paramString8)
        stringBuilder.append("state=")
        stringBuilder.append(paramString7)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("vip=")
        stringBuilder.append(paramString6)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(
                paramString10,
                paramString11,
                paramString1,
                consumerSecret
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun loglist(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("pn=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun memberLog(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("pn=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun motivateRead(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("doWhat=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun myhome(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun operatorLogOnsign(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun orderFuzhu(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun pubchapter(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("bID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("cID=")
        stringBuilder.append(paramString4)
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString5)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun pwdLogOn(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("pcd=")
        stringBuilder.append(paramString3)
        stringBuilder.append("pwd=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString5, paramString6, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun qqinterLogOn(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun shelfbooks(
        paramString1: String,
        paramLong1: Long,
        paramString2: String,
        paramInt: Int,
        paramLong2: Long,
        paramString3: String,
        paramString4: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("intBhSynTime=")
        stringBuilder.append(paramLong2)
        stringBuilder.append("pn=")
        stringBuilder.append(paramInt)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramLong1)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString2)
        stringBuilder.append("")
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun signInfo(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun tokenLogOn(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun userAnnul(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String,
        paramString8: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("dCode=")
        stringBuilder.append(paramString5)
        stringBuilder.append("pNo=")
        stringBuilder.append(paramString4)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        stringBuilder.append("vCode=")
        stringBuilder.append(paramString6)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString7, paramString8, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun userInfo(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun userRestore(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("dCode=")
        stringBuilder.append(paramString4)
        stringBuilder.append("pNo=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("vCode=")
        stringBuilder.append(paramString5)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun vCodeLogOn(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String,
        paramString6: String,
        paramString7: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("dCode=")
        stringBuilder.append(paramString4)
        stringBuilder.append("pNo=")
        stringBuilder.append(paramString3)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("vCode=")
        stringBuilder.append(paramString5)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString6, paramString7, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun wechatBind(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String,
        paramString5: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        stringBuilder.append("uID=")
        stringBuilder.append(paramString3)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString4, paramString5, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun wechatLogOn(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

    fun weiborLogOn(
        paramString1: String,
        paramString2: String,
        paramString3: String,
        paramString4: String
    ): String {
        var paramString1 = paramString1
        val stringBuilder = StringBuilder()
        stringBuilder.append("consumerKey=")
        stringBuilder.append(paramString1)
        stringBuilder.append("timestamp=")
        stringBuilder.append(paramString2)
        paramString1 = stringBuilder.toString()
        try {
            return SignMD5Util.createSign(paramString3, paramString4, paramString1, consumerSecret)
        } catch (exception: Exception) {
            exception.printStackTrace()
            return ""
        }

    }

}