//
//  GLViewController.m
//  Follow the Finger
//
//  Created by Seth Battis on 3/11/11.
//  Copyright __MyCompanyName__ 2011. All rights reserved.
//

#import "GLViewController.h"
#import "ConstantsAndMacros.h"
#import "OpenGLCommon.h"
#import "Torso.h"

#define SMOOTH_MOVE 2

@implementation GLViewController
- (void)drawView:(UIView *)theView
{
    glColor4f(0.0, 0.0, 0.0, 0.0);
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    
	glLoadIdentity();
	gluLookAt(0, 8, 2,
			  0, 0, 2,
			  0, 0, 1);
	if (abs(spin-target) < SMOOTH_MOVE)
	{
		spin = target;
	}
	if (spin < target)
	{
		spin += SMOOTH_MOVE;
	}
	else if (spin > target)
	{
		spin -= SMOOTH_MOVE;
	}
	glRotatef(180 + spin, 0, 0, 1);
    glPushMatrix();
	{
		glTranslatef(0, 0, -0.265);
		glScalef(1, 1.117, 1);
		drawTorso();
	}
	glPopMatrix();
	[sbh draw];
}

-(void)spin:(double)degrees
{
	target += degrees;
	[sbh spin:degrees];
	NSLog(@"Spinning %f to %f", degrees, target);
}

-(void)setupView:(GLView*)view
{
	const GLfloat zNear = 0.01, zFar = 1000.0, fieldOfView = 45.0; 
	GLfloat size; 
	glEnable(GL_DEPTH_TEST);
	glMatrixMode(GL_PROJECTION); 
	size = zNear * tanf(DEGREES_TO_RADIANS(fieldOfView) / 2.0); 
	CGRect rect = view.bounds; 
	glFrustumf(-size, size, -size / (rect.size.width / rect.size.height), size / 
			   (rect.size.width / rect.size.height), zNear, zFar); 
	glViewport(0, 0, rect.size.width, rect.size.height);  
	glMatrixMode(GL_MODELVIEW);
	
	glLoadIdentity(); 
	glEnable(GL_LIGHTING);
	glEnable(GL_LIGHT0);
	sbh = [[SBHead alloc] init];
}
- (void)dealloc 
{
    [super dealloc];
}
@end
