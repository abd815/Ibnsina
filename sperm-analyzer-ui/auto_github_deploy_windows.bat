@echo off
echo.
echo 🚀 سكريبت الرفع التلقائي لـ GitHub - Sperm Analyzer AI
echo ====================================================
echo.

REM التحقق من وجود git
git --version >nul 2>&1
if errorlevel 1 (
    echo ❌ خطأ: Git غير مثبت. يرجى تثبيت Git أولاً.
    echo تحميل من: https://git-scm.com/downloads
    pause
    exit /b 1
)

REM طلب معلومات GitHub
echo 📝 يرجى إدخال معلومات GitHub الخاصة بك:
set /p GITHUB_USERNAME="اسم المستخدم على GitHub: "
set /p REPO_NAME="اسم المستودع (اتركه فارغاً للافتراضي 'sperm-analyzer-ai'): "

REM تعيين اسم المستودع الافتراضي
if "%REPO_NAME%"=="" set REPO_NAME=sperm-analyzer-ai

REM التحقق من وجود المجلد
if not exist "sperm-analyzer-ui" (
    echo ❌ خطأ: مجلد 'sperm-analyzer-ui' غير موجود.
    echo يرجى التأكد من تنفيذ هذا السكريبت في المجلد الذي يحتوي على المشروع.
    pause
    exit /b 1
)

echo.
echo 📂 الانتقال إلى مجلد المشروع...
cd sperm-analyzer-ui

REM تهيئة Git repository
echo 🔧 تهيئة مستودع Git محلي...
git init

REM إضافة معلومات Git
echo 👤 تكوين معلومات Git...
git config user.name "%GITHUB_USERNAME%"
set /p GIT_EMAIL="البريد الإلكتروني لـ Git: "
git config user.email "%GIT_EMAIL%"

REM إضافة جميع الملفات
echo 📁 إضافة جميع ملفات المشروع...
git add .

REM إنشاء first commit
echo 💾 إنشاء commit أولي...
git commit -m "Initial commit: Sperm Analyzer AI Android App - Complete bilingual UI with medical-grade design, ready for Koyb.com integration"

REM ربط المستودع بـ GitHub
echo 🔗 ربط المستودع بـ GitHub...
git remote add origin https://github.com/%GITHUB_USERNAME%/%REPO_NAME%.git

REM عرض التعليمات النهائية
echo.
echo ✅ تم إعداد المشروع بنجاح!
echo.
echo 🔶 الخطوات التالية (يدوية):
echo 1. انتقل إلى GitHub.com وسجل الدخول
echo 2. أنشئ مستودع جديد باسم: %REPO_NAME%
echo 3. اجعل المستودع عام (Public) أو خاص (Private)
echo 4. لا تضع ملفات README أو .gitignore (موجودة بالفعل)
echo 5. بعد إنشاء المستودع، نفذ الأمر التالي:
echo.
echo    git push -u origin main
echo.
echo 🤖 GitHub Actions سيبدأ تلقائياً ببناء APK فور رفع الكود!
echo.
echo 📱 ستجد ملفات APK في:
echo    • GitHub → Actions → أحدث workflow → Artifacts
echo    • أو في Releases إذا كان push للـ main branch
echo.

REM إنشاء سكريبت push منفصل
echo @echo off > push_to_github.bat
echo echo 🚀 رفع المشروع إلى GitHub... >> push_to_github.bat
echo git push -u origin main >> push_to_github.bat
echo if %%errorlevel%% equ 0 ( >> push_to_github.bat
echo     echo ✅ تم رفع المشروع بنجاح! >> push_to_github.bat
echo     echo 🔗 انتقل إلى مستودع GitHub لمراقبة بناء APK >> push_to_github.bat
echo     echo ⏰ سيستغرق البناء 5-10 دقائق تقريباً >> push_to_github.bat
echo ^) else ( >> push_to_github.bat
echo     echo ❌ فشل في رفع المشروع >> push_to_github.bat
echo     echo 💡 تأكد من إنشاء المستودع على GitHub أولاً >> push_to_github.bat
echo ^) >> push_to_github.bat
echo pause >> push_to_github.bat

echo 📜 تم إنشاء سكريبت 'push_to_github.bat' لرفع الكود
echo.
echo 🏁 لإكمال العملية:
echo 1. أنشئ المستودع على GitHub
echo 2. نفذ: push_to_github.bat
echo.
echo 🎉 ستحصل على APK تلقائياً بعد 5-10 دقائق!
echo.
pause