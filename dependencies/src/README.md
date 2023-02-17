AEM Forms Mega Forms Demo Setup Instructions
===


## How to Use
The following archives can be downloaded and uploaded to your CRX Repository or can be deployed via the full stack pipeline
MegaFormsDemo-1.0.5.zip

FormsDemoConfig1.0.zip


### AEM Forms Mega Demo Pre-requisites
1.  Onboard AEM Forms as a Cloud Service or Setup AEM Forms Local Development environment
2.  Integrate Adobe Sign with AEM Forms as a Cloud service
https://experienceleague.adobe.com/docs/experience-manager-cloud-service/content/forms/integrate/adobe-sign-integration-adaptive-forms.html?lang=en
3.  Configure Power Automate (optional)
4.  Obtain Google API Key for Address Lookup (optional)
https://developers.google.com/maps/documentation/geocoding/get-api-key

#### AEM Forms as Cloud Service
Onboard AEM Forms as a Cloud Service
https://experienceleague.adobe.com/docs/experience-manager-cloud-service/content/forms/setup-environment/setup-forms-cloud-service.html?lang=en

#### AEM Forms Local Development Environment
Set AEM Forms local development environment
https://experienceleague.adobe.com/docs/experience-manager-cloud-service/content/forms/setup-environment/setup-local-development-environment.html?lang=en

#### Configure Power Automate on AEM Forms Cloud service
Video Instructions available here: https://experienceleague.adobe.com/docs/experience-manager-learn/cloud-service/forms/forms-cs-and-power-automate/integrate-formscs-power-automate.html?lang=en

1.  Create App Registration in Microsoft Azure
  	1.  Navigate and login into https://portal.azure.com/
  	2.  Under Azure services in the middle of the page, select "Azure Active Directory"
  	3.  In the Left menu bar, select "App registrations"
  	4.  Add a "New registration"  
      		1.  Enter a name for the app registration
      		2.  Under supported account types: Select "Accounts in this organizational directory only (Adobe only - Single tenant)"  
      		3.  Select the "Register" button

2.  Configure API Permissions
    1.  For the new registration you created, select "API permissions" in the left menu bar
    2.  Add the following permissions
        		"Flow Service"
        			Flows.Manage.All
        			Flows.Read.All
        		"Dynamics CRM"
        			user_impersonation

3.  Configure Redirect URL
    1.  Select "Authentication" in the left menu bar and add the following URL's for your AEM CS instance
      		https://<aemcsurl>/libs/fd/powerautomate/content/flowservice/config.html
      		https://<aemcsurl>/libs/fd/powerautomate/content/dataverse/config.html
	  2.  Save the changes

4.  Create certificates and secrets
    1.  Select "Certificates and secrets"
    2.  Select "New client secret"
      		Enter a description and expiration date and Select add
    3.  Copy the client secret
    4.  Copy the Application ID from the registration overview
    5.  Select "Endpoints" for your newly registered app, and copy the Oauth 2.0 authorization endpoint

5.  Configure Power Automate in AEM Forms
    1.  Configure Microsoft Power Automate Dataverse
          1.  In AEM, Navigate to Tools/Cloud services
          2.  Select Microsoft Power Automate Dataverse
          3.  Edit the dataverse configuration properties with the following:
              1.  Client ID = Application ID from the azure registration overview referenced above in step 4
              2.  Client Secret = The client ID referenced above in step 4
              3.  OAuth URL = the Oauth URL from step 4 above
              4.  Dynamics Environment URL = https://org5ca23ae9.crm.dynamics.com


    2.  Configure Microsoft Power Autoamte Flow service
          1.  In AEM, Navigate to Tools/Cloud services
          2.  Select Microsoft Power Automate Flowservice
          3.  Edit the dataverse configuration properties with the following:
              1.  Client ID = Application ID from the azure registration overview referenced above in step 4
              2.  Client Secret = The client ID referenced above in step 4
              3.  OAuth URL = the Oauth URL from step 4 above
              4.  Environment ID = Default-fa7b1b5a-7b34-4387-94ae-d2c178decee1

  6.  Configure AEM Power Automate Submit Action
      1.  In the Load Application Adaptive Form, located at /content/forms/af/megaform/LoanApplication.html
      2.  In the Form Container, navigate to the Submission section
          Select "Invoke a Power Automate Flow" in Submit Application
          In Action Configuration:  Select "LoanApplicationFlow_XSC"


#### Configure Google Maps Functionality
  1.  Obtain Google Map API Key here: https://developers.google.com/maps/documentation/geocoding/get-api-key
  2.  In your AEM Instance add the API Key to the following Content Fragment
      content/dam/megaformsdemo/megademoconfig
