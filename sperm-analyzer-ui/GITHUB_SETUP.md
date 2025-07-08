# إعداد GitHub لتطبيق محلل الحيوانات المنوية / GitHub Setup Guide

## 🚀 نشر المشروع على GitHub / Publishing to GitHub

### الخطوة 1: إنشاء مستودع GitHub جديد / Step 1: Create New Repository

1. انتقل إلى [GitHub.com](https://github.com) وسجل الدخول
2. انقر على "New Repository" أو "مستودع جديد"
3. اختر اسم المستودع: `sperm-analyzer-ai`
4. اجعل المستودع عام (Public) للوصول المفتوح أو خاص (Private) للخصوصية
5. لا تقم بتهيئة README أو .gitignore (موجودان بالفعل في المشروع)

### الخطوة 2: رفع الكود / Step 2: Upload Code

```bash
# في مجلد المشروع / In project directory
cd sperm-analyzer-ui

# تهيئة git / Initialize git
git init

# إضافة جميع الملفات / Add all files
git add .

# أول commit / First commit
git commit -m "Initial commit: Sperm Analyzer AI Android app with bilingual UI"

# ربط المستودع المحلي بـ GitHub / Connect to GitHub
git remote add origin https://github.com/YourUsername/sperm-analyzer-ai.git

# رفع الكود / Push code
git push -u origin main
```

### الخطوة 3: تكوين GitHub Actions / Step 3: Configure GitHub Actions

تم تضمين ملف `.github/workflows/build.yml` في المشروع والذي سيقوم بـ:
- ✅ بناء APK تلقائياً عند كل push
- ✅ إنشاء debug و release APK
- ✅ رفع APK كـ artifacts
- ✅ إنشاء releases تلقائية

## 📱 بناء APK محلياً / Build APK Locally

### الطريقة الأولى: استخدام سكريبت البناء / Method 1: Using Build Script

```bash
# جعل السكريبت قابل للتنفيذ / Make script executable
chmod +x build_apk.txt
mv build_apk.txt build_apk.sh

# تنفيذ السكريبت / Run script
./build_apk.sh
```

### الطريقة الثانية: استخدام Gradle مباشرة / Method 2: Direct Gradle

```bash
# بناء debug APK / Build debug APK
./gradlew assembleDebug

# بناء release APK / Build release APK  
./gradlew assembleRelease

# تنظيف المشروع / Clean project
./gradlew clean
```

## 🔧 التكوين المطلوب / Required Configuration

### متطلبات النظام / System Requirements
- **Android SDK**: API 23+ (Android 6.0)
- **Java/JDK**: 17 أو أحدث
- **Gradle**: 8.2 (مضمن في المشروع)
- **Android Studio**: Arctic Fox أو أحدث (اختياري)

### متغيرات البيئة / Environment Variables
```bash
# تعيين ANDROID_HOME / Set ANDROID_HOME
export ANDROID_HOME=/path/to/android-sdk
export PATH=$PATH:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
```

## 📦 مخرجات البناء / Build Outputs

عند البناء الناجح، ستجد ملفات APK في:

```
app/build/outputs/apk/
├── debug/
│   └── app-debug.apk               # للاختبار والتطوير
└── release/
    └── app-release-unsigned.apk    # للنشر (يحتاج توقيع)
```

## 🔑 توقيع APK للنشر / Signing APK for Release

### إنشاء keystore / Create Keystore
```bash
keytool -genkey -v -keystore sperm-analyzer-key.keystore -alias sperm-analyzer -keyalg RSA -keysize 2048 -validity 10000
```

### تعديل build.gradle / Modify build.gradle
```kotlin
android {
    signingConfigs {
        release {
            storeFile file("../sperm-analyzer-key.keystore")
            storePassword "your_store_password"
            keyAlias "sperm-analyzer" 
            keyPassword "your_key_password"
        }
    }
    buildTypes {
        release {
            signingConfig signingConfigs.release
            // ... باقي الإعدادات
        }
    }
}
```

## 🚀 GitHub Releases التلقائية / Automatic GitHub Releases

تم تكوين GitHub Actions لإنشاء releases تلقائية:

1. **عند push إلى main**: ينشئ release جديد
2. **رقم الإصدار**: يتم إنشاؤه تلقائياً (v1, v2, etc.)
3. **محتوى الـ Release**: يتضمن وصف المميزات وملفات APK
4. **Assets**: debug و release APK مرفقان تلقائياً

## 📋 قائمة التحقق / Checklist

قبل النشر على GitHub، تأكد من:

- ✅ اختبار التطبيق على جهاز فعلي
- ✅ التحقق من عمل جميع الشاشات
- ✅ اختبار تبديل اللغات
- ✅ فحص التطبيق في الوضع المظلم والفاتح
- ✅ التأكد من صحة النصوص العربية والإنجليزية
- ✅ اختبار رفع الملفات والكاميرا (mock)
- ✅ مراجعة إعدادات التطبيق

## 🔗 روابط مفيدة / Useful Links

- [Android Developer Guide](https://developer.android.com/)
- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Material Design 3](https://m3.material.io/)
- [GitHub Actions for Android](https://github.com/actions/setup-java)
- [APK Signing Guide](https://developer.android.com/studio/publish/app-signing)

## 📞 الدعم / Support

للدعم الفني أو الاستفسارات:
- 📧 Email: support@koyb.com
- 🌐 Website: https://koyb.com
- 📱 GitHub Issues: استخدم issues في المستودع

---

**تم إعداد هذا الدليل بواسطة فريق Koyb Medical Solutions**