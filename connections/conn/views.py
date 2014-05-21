from django.shortcuts import render
from django.http import HttpResponse

def index(request):
	context = {}
	return render(request, 'ind.html', context)

def signup(request):
	context = {}
	return render(request, 'signup.html', context)

def dashboard(request):
	context = {}
	return render(request, 'dashboard.html', context)

def login(request):
	context = {}
	return render(request, 'login.html', context)

def message(request):
	context = {}
	return render(request, 'message.html', context)

def upgrade(request):
	context = {}
	return render(request, 'upgrade.html', context)