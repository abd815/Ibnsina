# محلل الحيوانات المنوية بالذكاء الاصطناعي / Sperm Analyzer AI

<div align="center">

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Kotlin](https://img.shields.io/badge/Kotlin-0095D5?&style=for-the-badge&logo=kotlin&logoColor=white)
![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=jetpackcompose&logoColor=white)
![Material Design](https://img.shields.io/badge/Material%20Design-757575?style=for-the-badge&logo=material-design&logoColor=white)

[![Build APK](https://github.com/yourusername/sperm-analyzer-ai/actions/workflows/build.yml/badge.svg)](https://github.com/yourusername/sperm-analyzer-ai/actions/workflows/build.yml)
[![Release](https://img.shields.io/github/v/release/yourusername/sperm-analyzer-ai)](https://github.com/yourusername/sperm-analyzer-ai/releases)
[![License](https://img.shields.io/badge/license-Proprietary-red)](LICENSE)

</div>

## 📱 نظرة عامة / Overview

### العربية
تطبيق Android متقدم ومتجاوب ومتعدد اللغات (العربية والإنجليزية) مصمم لتحليل الحيوانات المنوية باستخدام الذكاء الاصطناعي. يوفر هذا التطبيق واجهة مستخدم احترافية للمهنيين الطبيين لتحليل عينات الحيوانات المنوية باستخدام تقنيات الذكاء الاصطناعي المتطورة.

### English
A modern, responsive, and bilingual (Arabic + English) Android application for AI-powered sperm analysis. This app provides a professional user interface for medical professionals to analyze sperm samples using advanced artificial intelligence techniques.

## ✨ المميزات / Features

### 🔬 الوظائف الأساسية / Core Functionality
- **رفع الملفات والتصوير** / **File Upload & Camera Capture**: واجهة سحب وإفلات مع دعم الفيديوهات والصور
- **تتبع التقدم في الوقت الفعلي** / **Real-time Progress**: مؤشرات تقدم متحركة مع تقدير الوقت
- **عرض النتائج التفصيلية** / **Detailed Results**: نتائج تحليل شاملة مع تراكبات بصرية
- **خيارات التصدير** / **Export Options**: إمكانيات تصدير PDF و CSV
- **إدارة الإعدادات** / **Settings Management**: تبديل اللغة، تبديل المظهر، وتكوين الخادم

### 🎨 التصميم وتجربة المستخدم / Design & UX
- **جمالية طبية متدرجة** / **Medical-Grade Aesthetic**: تصميم احترافي مناسب للبيئات السريرية
- **دعم ثنائي اللغة** / **Bilingual Support**: ترجمة كاملة للعربية والإنجليزية مع دعم RTL
- **Material Design 3**: مكونات واجهة مستخدم حديثة تتبع أحدث نظام تصميم من Google
- **تخطيط متجاوب** / **Responsive Layout**: محسن للهواتف Android (دقة مستهدفة 360x800)
- **المظهر المظلم** / **Dark Theme**: واجهة مظلمة صديقة للمهنيين الطبيين

## 📱 لقطات الشاشة / Screenshots

### الشاشة الرئيسية / Main Screen
- منطقة رفع الملفات بالسحب والإفلات
- أزرار الرفع والكاميرا
- معاينة الملف مع البيانات الوصفية

### شاشة التحليل / Analysis Screen
- معاينة الوسائط مع تراكب الذكاء الاصطناعي
- صناديق التحديد المتحركة التي تظهر الكشف
- شريط التقدم مع تقدير الوقت

### شاشة النتائج / Results Screen
- الوسائط المحللة مع صناديق التحديد النهائية
- عرض المقاييس التفصيلية
- خيارات التصدير

### شاشة الإعدادات / Settings Screen
- اختيار اللغة (العربية/الإنجليزية)
- تبديل المظهر
- تكوين عنوان URL للخادم

## 🏗️ هيكل المشروع / Project Structure

```
app/
├── src/main/
│   ├── java/com/koyb/spermanalyzer/
│   │   ├── MainActivity.kt                 # نقطة الدخول الرئيسية
│   │   ├── data/
│   │   │   └── Models.kt                   # نماذج البيانات والبيانات الوهمية
│   │   ├── ui/
│   │   │   ├── screens/
│   │   │   │   ├── MainScreen.kt          # رفع الملفات والتقاط
│   │   │   │   ├── AnalysisScreen.kt      # تتبع التقدم
│   │   │   │   ├── ResultsScreen.kt       # نتائج التحليل
│   │   │   │   └── SettingsScreen.kt      # تكوين التطبيق
│   │   │   └── theme/
│   │   │       ├── Color.kt               # تعريفات الألوان
│   │   │       ├── Type.kt                # إعداد الطباعة
│   │   │       └── Theme.kt               # مظهر Material Design
│   │   └── utils/
│   │       └── LanguageUtils.kt           # إدارة اللغة
│   └── res/
│       ├── values/
│       │   ├── strings.xml                # النصوص الإنجليزية
│       │   ├── colors.xml                 # موارد الألوان
│       │   └── themes.xml                 # مظاهر التطبيق
│       ├── values-ar/
│       │   └── strings.xml                # النصوص العربية
│       └── xml/
│           └── file_paths.xml             # مسارات مزود الملفات
```

## 🚀 البناء والتثبيت / Build & Installation

### التطلبات المسبقة / Prerequisites
- Android Studio Arctic Fox أو أحدث
- Android SDK 23+ (API level 23)
- Kotlin 1.8+
- JDK 17

### التثبيت السريع / Quick Installation

#### تحميل APK مباشرة / Direct APK Download
1. انتقل إلى [صفحة الإصدارات](https://github.com/yourusername/sperm-analyzer-ai/releases)
2. حمل أحدث ملف APK
3. ثبت على جهاز Android الخاص بك

#### البناء من المصدر / Build from Source
```bash
# استنساخ المستودع / Clone repository
git clone https://github.com/yourusername/sperm-analyzer-ai.git
cd sperm-analyzer-ai

# بناء APK التطوير / Build debug APK
./gradlew assembleDebug

# بناء APK الإصدار / Build release APK
./gradlew assembleRelease
```

### البناء التلقائي / Automated Build
يستخدم هذا المشروع GitHub Actions للبناء التلقائي:
- ✅ البناء التلقائي عند كل push
- ✅ تحميل APK كـ artifacts
- ✅ إنشاء إصدارات تلقائية
- ✅ دعم الفروع المتعددة

## 🌍 الدعم ثنائي اللغة / Bilingual Support

### العربية / Arabic
- ✅ تخطيط RTL كامل
- ✅ خط Cairo للعربية
- ✅ ترجمة كاملة
- ✅ تبديل ديناميكي للغة

### الإنجليزية / English
- ✅ تخطيط LTR قياسي
- ✅ خط Roboto للإنجليزية
- ✅ Material Design typography
- ✅ تحسين للقراءة

## 🎨 نظام التصميم / Design System

### لوحة الألوان / Color Palette
```kotlin
val DeepNavyBlue = Color(0xFF0D1B2A)    // الخلفية الأساسية
val SecondaryNavy = Color(0xFF1B263B)   // السطح الثانوي
val CyanBlue = Color(0xFF00B4D8)        // اللون المميز
val TextPrimary = Color(0xFFFFFFFF)     // النص الأساسي
val TextSecondary = Color(0xFFB0BEC5)   // النص الثانوي
```

### التطبيقات / Typography
- **العربية**: عائلة خط Cairo مع معالجة مناسبة للنص العربي
- **الإنجليزية**: عائلة خط Roboto تتبع إرشادات Material Design
- **الأحجام**: العناوين (20sp+), النص الأساسي (14-16sp), التسميات (12sp)

## 🔧 التكامل مع الخادم / Backend Integration

### جاهز لـ Koyb.com Backend
- **عنوان URL قابل للتكوين**: شاشة الإعدادات تسمح بتكوين نقطة نهاية API
- **هيكل البيانات الوهمية**: جميع نماذج البيانات تعكس استجابات API المتوقعة
- **رفع الملفات جاهز**: معالجة الملفات محضرة لرفع multipart
- **تتبع التقدم**: تحديثات التقدم في الوقت الفعلي من تحليل الخادم

### نماذج البيانات / Data Models
```kotlin
data class AnalysisResult(
    val spermCount: Int,
    val motilityScore: Float,
    val density: Float,
    val motilityGrade: MotilityGrade,
    val densityGrade: DensityGrade,
    val boundingBoxes: List<SpermBoundingBox>
)
```

## 📋 خريطة الطريق / Roadmap

### الإصدار الحالي / Current Version
- ✅ واجهة مستخدم كاملة
- ✅ دعم ثنائي اللغة
- ✅ Material Design 3
- ✅ بيانات وهمية للاختبار

### الإصدارات القادمة / Upcoming Versions
- 🔄 تكامل الخادم الحقيقي
- 🔄 صلاحيات الكاميرا الفعلية
- 🔄 التحقق من صحة الملفات
- 🔄 الوضع غير المتصل
- 🔄 خيارات تصدير محسنة

## 🏥 التصميم الطبي المتدرج / Medical-Grade Design

تم تصميم هذه الواجهة خصيصاً للبيئات الطبية والمختبرية:

- **الجماليات المهنية**: لغة تصميم نظيفة وسريرية
- **تباين عالي**: محسن لظروف الإضاءة المختلفة
- **منع الأخطاء**: ردود فعل بصرية واضحة ومربعات حوار التأكيد
- **إمكانية الوصول**: أهداف لمس كبيرة ونص قابل للقراءة
- **خصوصية البيانات**: خيارات التخزين المحلي والاتصال الآمن بالخادم

## 🤝 المساهمة / Contributing

هذا مشروع تصميم واجهة مستخدم. للتكامل مع الخادم أو الميزات الإضافية، يرجى التنسيق مع فريق تطوير Koyb.com.

## 📄 الترخيص / License

هذا المشروع مصمم لـ Koyb Medical Solutions. جميع الحقوق محفوظة.

---

<div align="center">

**تم البناء بـ ❤️ باستخدام Jetpack Compose و Material Design 3**

**Built with ❤️ using Jetpack Compose and Material Design 3**

[تحميل APK](https://github.com/yourusername/sperm-analyzer-ai/releases) • [التوثيق](docs/) • [الدعم](mailto:support@koyb.com)

</div>