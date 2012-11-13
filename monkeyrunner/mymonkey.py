# coding:utf-8

from com.android.monkeyrunner import MonkeyDevice
from com.android.monkeyrunner import MonkeyRunner


## 起動設定
mDeviceId = 'emulator-5554'  ## change me
mPackage = 'hm.moe.heignamerican.mymonkey'
mActivity = 'MonkeyActivity'
mApkFile = 'MyMonkey.apk'


mDevice = None
# ボタンの位置などの指定。端末依存
# 今回は MonkeyRecorder で取得
class B:
        SARU_01 = (43,108)
        SARU_02 = (172,111)
        SARU_03 = (264,115)
        SARU_07 = (252,161)
        SARU_25 = (54,543)
        TORI_14 = (51,401)
        TORI_BACK = (81,111)

def touch(aPosition):
        mDevice.touch(aPosition[0],aPosition[1],MonkeyDevice.DOWN_AND_UP)
def moveToToriFromSaru():
        touch(B.SARU_01)
        touch(B.SARU_02)
def moveToSaruFromTori():
        touch(B.TORI_BACK)
def finishFromSaru():
        touch(B.SARU_07)
        touch(B.SARU_03)
        touch(B.SARU_25)
def crashAtTori():
        touch(B.TORI_14)
def wait():
        MonkeyRunner.sleep(3.0)


if __name__ == '__main__':
        mDevice = MonkeyRunner.waitForConnection(deviceId=mDeviceId)
        tRunComponent = mPackage + '/' + mPackage + '.' + mActivity
        mDevice.installPackage(mApkFile)
        mDevice.startActivity(component=tRunComponent)

        wait()
        moveToToriFromSaru()
        wait()
        ##crashAtTori()
        moveToSaruFromTori()
        wait()
        finishFromSaru()



"""
= 注意点
 * エミュレータ
  * Android 2.3.3 (API-level 10)
  * Skin WVGA800
  * density 240
= 疑問点
 * 終了状態、成功／失敗はどう判別するのか？
"""
